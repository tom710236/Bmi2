package com.example.tom.bmi2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/*
第二個Activity
新增後系統會產生Activity(java類別)Layout(版面配置檔 XML)
AndroidManifest.xml中會加入一個Activity元素)
 */

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //取得上一個Activity得資料
        //先呼叫Activity所提供的方法getIntent()得到Intent物件
        Intent intent = getIntent();
        //取得Bundle物件後 再一一取得資料
        Bundle bag = intent.getExtras();
        float bmi = bag.getFloat("BMI",0);
        //String 沒有0 用 null
        String test = bag.getString("Test",null);

        /*
        //取得上一個Activity得資料
        //先呼叫Activity所提供的方法getIntent()得到Intent物件
        Intent intent = getIntent();
        //使用getXXXExtra來取得資料(XXX=資料類別 int float char ....)
        //參數(資料標籤,找不到資料的預測值)
        float bmi = intent.getFloatExtra("BMI",0);
        // 取得代表佈局中 TextView 的物件
        */
        TextView txv1 = (TextView)findViewById(R.id.textView);
        //在txv1中顯示出("BMI值"+bmi+test)值為Testing
        //test
        txv1.setText("BMI值"+bmi+test);
    }
}
