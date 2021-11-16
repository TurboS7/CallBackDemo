package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyCallBack {
private TextView tv_info;
private EditText et_num1,et_num2;
private  MySDK mySDK;
private  String str = "";
private final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mySDK = new MySDK();
    }
    private void initView(){
        tv_info  = findViewById(R.id.tv_info);
        et_num1 = findViewById(R.id.et_num1);
        et_num2 = findViewById(R.id.et_num2);
    }
    @Override
    public void onPlus(int res, boolean isPositive) {
        Log.i(TAG, "onPlus: res:"+res+",isPositive:"+isPositive);
        System.out.println("onPlus：res="+res+","+(isPositive?"正数":"负数"));
        str = str+"onPlus：res="+res+","+(isPositive?"正数":"负数")+"\n";
        tv_info.setText(str);
    }

    @Override
    public void onSubtract(int res, boolean isPositive) {
        Log.i(TAG, "onSubtract: res："+res+",isPositive："+isPositive);
        System.out.println("onSubtract：res="+res+","+(isPositive?"正数":"负数"));
        str = str+"onSubtract：res="+res+","+(isPositive?"正数":"负数")+"\n";
        tv_info.setText(str);
    }

    public void onAddCallback(View view) {
        mySDK.addCallback(this);
        int callbackSize = mySDK.getCallbackSize();
        Toast.makeText(this, "CurrentCallbackSize："+callbackSize, Toast.LENGTH_SHORT).show();
    }
    public void onRemoveCallback(View view) {
        mySDK.removeCallback(this);
        int callbackSize = mySDK.getCallbackSize();
        Toast.makeText(this, "CurrentCallbackSize："+callbackSize, Toast.LENGTH_SHORT).show();
        if (mySDK.getCallbackSize()<=0){
            tv_info.setText("");
        }
    }
    public void onplus(View view) {
        str = "";
        int a = Integer.valueOf(et_num1.getText().toString());
        int b = Integer.valueOf(et_num2.getText().toString());
        int callbackSize = mySDK.getCallbackSize();
        if (callbackSize>0){
            mySDK.plus(a,b);
        }else{
            Toast.makeText(this, "请先添加回调！", Toast.LENGTH_SHORT).show();
        }
    }
    public void onSub(View view) {
        str = "";
        int a = Integer.valueOf(et_num1.getText().toString());
        int b = Integer.valueOf(et_num2.getText().toString());
        int callbackSize = mySDK.getCallbackSize();
        if (callbackSize>0){
            mySDK.subtract(a,b);
        }else{
            Toast.makeText(this, "请先添加回调！", Toast.LENGTH_SHORT).show();
        }

    }
}