package com.ar.evan.arnavigation.activity;

import android.content.Intent;
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
import com.ar.evan.arnavigation.helper.FAST;
import com.ar.evan.arnavigation.model.DataVO;
import com.ar.evan.arnavigation.model.LocationInfoBean;
import com.ar.evan.arnavigation.model.LocationListVO;
import com.ar.evan.arnavigation.model.PeopleVO;
import com.ar.evan.arnavigation.model.ResultBean;
import com.ar.evan.arnavigation.model.ResultVO;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Test2Activity extends AppCompatActivity {
    RequestQueue mQueue;
    /**
     * 设置TAG
     */
    public static final String TAG = "MyTag";

    private TextView textView;
    private Button button;
    //private  static ResultBean resultBean = new ResultBean();
    private ResultVO resultVO=new ResultVO();
    private DataVO dataVO=new DataVO();
    private LocationListVO locationListVO=new LocationListVO();
    PeopleVO peopleVO=new PeopleVO();
    List<LocationListVO>locationListVOList=new ArrayList<LocationListVO>();
    List<PeopleVO>peopleVOList=new ArrayList<PeopleVO>();

    /**
     * create
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        findViews(); // 声明控件对象
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                String param=intent.getStringExtra("content");
                mQueue = Volley.newRequestQueue(Test2Activity.this);
                String url="http://uae5f2.natappfree.cc/ar/client/location/show?scanId=";
                url+=param;
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        //第一个参数，请求的网址
                        url,
                        //第二个参数
                        null,
                        //响应正确时的处理
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                Log.d("TAG", response.toString());
                                String mJSON = response.toString();
                                //获得第一层对象
                                resultVO= FAST.parseObject(mJSON,ResultVO.class);
                                //获得第二层对象
                                dataVO=FAST.parseObject(resultVO.getData(),DataVO.class);
                                //获得第三层链表
                                locationListVOList=FAST.parseArray(dataVO.getLocations(),LocationListVO.class);
                                //resultBean = JSON.parseObject(mJSON, ResultVO.class);
                                // List<ResultBean.DataBean.LocationListBean> locationListBeanList=JSON.parseObject(mJSON,ResultBean.class).getData().getLocationList();

                                // textView=findViewById(R.id.textView3);
                                textView.setText(resultVO.getMsg().toString());
                                System.out.print("初始化链表信息。。。。");
                                 List<LocationInfoBean> locationInfoBeanList=new ArrayList<>();
                                System.out.print("遍历链表信息。。。。");

                                for(LocationListVO locationListVO: locationListVOList){
                                    LocationInfoBean locationInfoBean=new LocationInfoBean();
                                    locationInfoBean.setLocationName(locationListVO.getName());
                                    locationInfoBean.setLatitude(locationListVO.getLatitude());
                                    locationInfoBean.setAltitude(locationListVO.getAltitude());
                                    System.out.print("此时的链表信息。。。。");
                                    locationInfoBeanList.add(locationInfoBean);

            }
            System.out.println("位置链表信息"+locationInfoBeanList);
                                Intent intent=new Intent();
                                Bundle bundle=new Bundle();

                                intent.setClass(Test2Activity.this,ARActivity.class);
                                bundle.putSerializable("locationInfoBeanList",(Serializable)locationInfoBeanList);
                                intent.putExtras(bundle);
                                //intent.putExtra("locationInfoBeanList", (Serializable) locationInfoBeanList);
                                startActivity(intent);
                            }
                        },
                        //响应错误时的处理
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("TAG", error.getMessage(), error);
                            }
                        });
                //把这个请求加到Volley队列即可
                mQueue.add(jsonObjectRequest);

            }

        });
    }


    private void findViews() {
        button =  findViewById(R.id.displayButton3);
       textView = findViewById(R.id.textView3);
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

}
