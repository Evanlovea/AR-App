package com.ar.evan.arnavigation.activity;

import android.Manifest;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import com.ar.evan.arnavigation.R;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;


import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button scanBtn;
    private TextView result;
    private int REQUEST_CODE_SCAN = 111;
    private Button enterOtherActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        /*扫描按钮*/
        scanBtn = findViewById(R.id.scanBtn);
        scanBtn.setOnClickListener(this);
        result=findViewById(R.id.resultData);
     /*   enterOtherActivity.findViewById(R.id.tiaozhuan);
        enterOtherActivity.setOnClickListener(this);*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scanBtn:

                AndPermission.with(this)
                        .permission(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
                        .callback(new PermissionListener() {
                            @Override
                            public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);

                                /*ZxingConfig是配置类  可以设置是否显示底部布局，闪光灯，相册，是否播放提示音  震动等动能
                                * 也可以不传这个参数
                                * 不传的话  默认都为默认不震动  其他都为true
                                * */

                                ZxingConfig config = new ZxingConfig();
                                config.setPlayBeep(true);
                                config.setShake(true);
                                intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);

                                startActivityForResult(intent, REQUEST_CODE_SCAN);
                            }

                            @Override
                            public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {

                                Uri packageURI = Uri.parse("package:" + getPackageName());
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                                startActivity(intent);

                                Toast.makeText(MainActivity.this, "没有权限无法扫描呦", Toast.LENGTH_LONG).show();
                            }
                        }).start();
                break;
            /*case R.id.tiaozhuan:
                String content=result.getText().toString().trim();
                if(TextUtils.isEmpty(content)){
                    Toast.makeText(this,"请先扫描二维码后再试",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent=new Intent(this,ScanResultActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("content",content);
                    intent.putExtra("scanResultContent",bundle);
                    startActivity(intent);

                }
                break;*/
            default:
        }
    }
    @Override
    public  void  onStart(){
        super.onStart();
    }
    @Override
    public void onResume(){
        super.onResume();
       /* enterOtherActivity.findViewById(R.id.tiaozhuan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=result.getText().toString().trim();
                if(TextUtils.isEmpty(content)){
                    Toast.makeText(MainActivity.this,"请先扫描二维码后再试",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent=new Intent(MainActivity.this,ScanResultActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("content",content);
                    intent.putExtra("scanResultContent",bundle);
                    startActivity(intent);

                }
            }
        });*/
    }
    @Override
    public void onPause(){
        super.onPause();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {

            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);
                result.setText("扫描结果为：" + content);
                Intent intent=new Intent(this,Test2Activity.class);
                intent.putExtra("content",content);
                startActivity(intent);



            }
        }
    }

}