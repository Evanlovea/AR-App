package com.ar.evan.arnavigation.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ar.evan.arnavigation.R;
import com.ar.evan.arnavigation.model.ARPoint;
import com.ar.evan.arnavigation.model.LocationInfoBean;
import com.ar.evan.arnavigation.model.ResultBean;
import com.longsh.optionframelibrary.OptionMaterialDialog;

import org.json.JSONObject;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 扫描结果以及解析数据
 *
 */
public class ScanResultActivity extends AppCompatActivity {
    /**
     * 初始化相关变量
     */

    String content="";
    Integer scanId=0;
    private static final int MSG_SUCCESS = 0;//获取信息成功的标识
    private static final int MSG_FAILURE = 1;//获取信息失败的标识
    private TextView textView;
    //List<ARPoint>arPointList=new ArrayList<>();
    List<LocationInfoBean> locationInfoBeanList=new ArrayList<>();
    LocationInfoBean locationInfoBean=new LocationInfoBean();
    /**
     * 设置TAG
     */
    public static final String TAG = "MyTag";

    /**
     * 这里拿到的RequestQueue是一个请求队列对象，
     * 它可以缓存所有的HTTP请求，然后按照一定的算法并发地发出这些请求。
     * RequestQueue内部的设计就是非常合适高并发的，
     * 因此我们不必为每一次HTTP请求都创建一个RequestQueue对象，
     * 这是非常浪费资源的，基本上在每一个需要和网络交互的Activity中创建一个RequestQueue对象就足够了。
     * */
    RequestQueue mQueue;
    //用于更新UI线程的handler
    private Handler mHandler=new Handler(){
        //此方法在UI线程中执行
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                case MSG_SUCCESS:
                   ResultBean resultBean =(ResultBean)msg.obj; //获取消息信息
                 /*   System.out.print("jieguo"+resultBean.getData().getLocationList());*/
                    Log.i(TAG, "handleMessage: 获取成功");
                   /* textView.setText(resultBean.getData().getLocationList().toString().trim());*/
                   /* final OptionMaterialDialog mMaterialDialog = new OptionMaterialDialog(ScanResultActivity.this);
                    mMaterialDialog.setTitle("标题")
//                .setTitleTextColor(R.color.colorPrimary)
//                .setTitleTextSize((float) 22.5)
                            .setMessage("数据解析成功")
//                .setMessageTextColor(R.color.colorPrimary)
//                .setMessageTextSize((float) 16.5)
//                .setPositiveButtonTextColor(R.color.colorAccent)
//                .setNegativeButtonTextColor(R.color.colorPrimary)
//                .setPositiveButtonTextSize(15)
//                .setNegativeButtonTextSize(15)
                            .setPositiveButton("确定", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mMaterialDialog.dismiss();
                                }
                            })
                            .setNegativeButton("取消",
                                    new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            mMaterialDialog.dismiss();
                                        }
                                    })
                            .setCanceledOnTouchOutside(true)
                            .setOnDismissListener(
                                    new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {
                                            //对话框消失后回调
                                        }
                                    })
                            .show();
*/


                    break;
                case MSG_FAILURE:
                      textView.setText("获取信息失败，请稍后重试");
                    break;
            }
        }
    };

    /**
     * 当一个Activity创建时会调用该方法，通过我们可以在该方法中进行组件的初始化工作
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);
        textView=findViewById(R.id.textView2);
        Button button=findViewById(R.id.displayButton);
        /**
         * 取值操作
         */
        Intent intent=getIntent();
        System.out.println("2-"+intent);
        String content=intent.getStringExtra("content");

        mQueue = Volley.newRequestQueue(this);
        new Thread(new HandleResultData()).start();//在新线程中读取数据并绑定
    }
    /**
     * 在Activity可见，但还不能进行交互时会调用该方法
     * 在onCreate之后调用
     */
    @Override
    protected void onStart() {
        super.onStart();


    }

    /**
     * 当Activity可以交互时调用
     * 在onStart之后调用,该方法被调用后就表示Activity进入了激活状态
     * resumed状态
     */
    @Override
    protected void onResume() {
        super.onResume();

    }

    /**
     * 一个从stopped状态的Activity重新被激活时调用
     * 接着会调用onStart()方法
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
    }

    /**
     * 当前Activity被另一个Activity覆盖，失去焦点，但还可见，不能交互
     * 那么此时当前Activity进入了paused状态（暂停状态）
     * 当此状态下Activity重新获取焦点时会再调用onResume()方法
     */
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }



    /**
     * 当前Activity被另一个Activity完全覆盖，不可见且不可交互
     * 那么此时当前Activity进入了stopped状态（停止状态）
     * 此状态下的Activity被重新显示时，会调用OnRestart()方法
     */
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Main2Activity-onStop");
        super.onStop();
        /**
         * 取消Request
         */
        if (mQueue != null) {
            mQueue.cancelAll(TAG);
        }
    }

    /**
     * 当前Activity被销毁时调用，表示结束生命周期
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Main2Activity-onDestroy");
    }

/*
    public void openActivity(View v){
        //打开另一个Activity,一个Intent对象代表一个意图
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);//启动Activity
    }
*/

    /**
     * 数据解析操作
     */
    public class HandleResultData implements Runnable{
        @Override
        public  void run(){
            String RequestUrl="http://uae5f2.natappfree.cc/ar/client/location/show?scanId=1";
          /*  String RequestParam="";
            try {
                    *//*
                     * 注：volley中的参数必须进行编码，不然会出现乱码问题
                     * *//*
                RequestParam= URLEncoder.encode(content,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            RequestUrl+=RequestParam;*/
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(

                    //第一个参数，请求的网址
                    RequestUrl,
                    //第二个参数
                    null,
                    //响应正确时的处理
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("TAG", response.toString());
                            /**
                             * 解析Json为Object
                             */
                            String mJSON = response.toString();
                            ResultBean resultBean=new ResultBean();
                            resultBean = JSON.parseObject(mJSON,ResultBean.class);
                            /**
                             * 绑定数据过程
                             */
                            mHandler.obtainMessage(MSG_SUCCESS,resultBean).sendToTarget();
                            /**
                             * 加入链表
                             */
                       /*     for(ResultBean.DataBean.LocationListBean locationListBean: resultBean.getData().getLocationList()){
                                  locationInfoBean.setLocationName(locationListBean.getName());
                                  locationInfoBean.setLatitude(locationListBean.getLatitude());
                                  locationInfoBean.setAltitude(locationListBean.getAltitude());
                                  locationInfoBeanList.add(locationInfoBean);
                            }*/
                            /**
                             * 将链表数据传值
                             */
                           /* button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent();
                                    intent.setClass(ScanResultActivity.this,ARActivity.class);
                                    intent.putExtra("locationInfoBeanList", (Serializable) locationInfoBeanList);
                                    startActivity(intent);
                                }
                            });*/

                        }

                    },
                    //响应错误时的处理
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("TAG", error.getMessage(), error);
                            mHandler.obtainMessage(MSG_FAILURE).sendToTarget();
                        }
                    });
            //把这个请求加到Volley队列即可
            jsonObjectRequest.setTag(TAG);
            mQueue.add(jsonObjectRequest);

        }




    }
}

