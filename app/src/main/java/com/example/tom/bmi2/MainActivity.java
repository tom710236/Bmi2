package com.example.tom.bmi2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //宣告
    EditText ed1;
    EditText ed2;
    Button bt1,bt2;
    TextView tx1;
    String w ;
    String h ;
    Float bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //取得代表布局
        ed1= (EditText)findViewById(R.id.editText);
        ed2= (EditText)findViewById(R.id.editText2);
        bt1=(Button)findViewById(R.id.button3);
        bt2=(Button)findViewById(R.id.button4);
        tx1=(TextView)findViewById(R.id.textView6);




    }
    public void onClick (View v) {
        //先取得EditText上的文字
        w=ed1.getText().toString();
        h=ed2.getText().toString();
        //排除ed1 ed2 無輸入數字會當機狀況
        if (ed1.length() != 0 && ed2.length() != 0) {
            //字串轉數字才能進行運算
            float weight = Float.parseFloat(w);
            float height = Float.parseFloat(h);
            bmi = weight / (height * height);
            //setText只能呈現字串 所以用String.valueOf(bmi)把bmi轉成字串
            tx1.setText(String.valueOf(bmi));
            //log.d(標籤Tag,想顯示的字串訊息)
            Log.d("txl",String.valueOf(bmi));

            //Toast 浮動顯示 (this,想要顯示的字串值,顯示時間長短)
            Toast.makeText(this, String.valueOf(bmi), Toast.LENGTH_LONG).show();
        }
        // ed1 ed2 無輸入數字時告知
        else if (w.length() == 0 || h.length() == 0) {
            Toast.makeText(this, "請輸入身高體重", Toast.LENGTH_LONG).show();
        }
        //用Intent 轉換到另一個 Activity
        //建構 Intent (new Intent(出發的Activity,目的地的類別)
        Intent intent = new Intent(this,ResultActivity.class);
        //傳遞複雜的資料 Bundle(先將要傳遞的資料裝成一袋 再讓Intent傳遞過去)
        //先產生一個Bundle的物件
        Bundle bag = new Bundle();
        //在使用putXXX方法 放入不同型態資料 (XXX=型態 Flong String...)
        bag.putFloat("BMI",bmi);
        bag.putString("Test","Testing");
        //把上面的資料通通放在一起
        intent.putExtras(bag);
        //實作轉換到另一個Activity的動作a
        startActivity(intent);

        /*
        //用Intent 轉換到另一個 Activity
        //建構 Intent (new Intent(出發的Activity,目的地的類別)
        Intent intent = new Intent(this,ResultActivity.class);
        //傳遞簡單資料
        //intent.putExtra(指定的名稱字串,所要傳遞的資料)
        intent.putExtra("BMI",bmi);
        //實作轉換到另一個Activity的動作
        startActivity(intent);
        */
    }
    //對話框按鈕
    //先產生 再呼叫 最後在顯示
    public void onClick2 (View v){
        new AlertDialog.Builder(this).setMessage("bmi=體重kg/身高m平方")
                .setTitle("bmi計算方式")
                .setPositiveButton("ok",null)
                .show();
        }
}
