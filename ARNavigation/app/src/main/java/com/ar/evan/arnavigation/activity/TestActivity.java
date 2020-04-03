package com.ar.evan.arnavigation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ar.evan.arnavigation.R;
import com.ar.evan.arnavigation.model.LocationInfoBean;

import java.util.List;

public class TestActivity extends AppCompatActivity {
    TextView textView;
    String content="";
    List<LocationInfoBean> locationInfoBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView=findViewById(R.id.testTextView5);
        Intent intent=this.getIntent();
        locationInfoBeanList= (List<LocationInfoBean>) intent.getSerializableExtra("locationInfoBeanList");
        content=locationInfoBeanList.get(0).getLocationName();
        System.out.print(content);
        textView.setText(content);
    }
    @Override
    public void onResume() {
        super.onResume();

    }
}
