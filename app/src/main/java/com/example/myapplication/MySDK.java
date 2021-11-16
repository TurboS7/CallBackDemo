package com.example.myapplication;

import android.util.Log;

import java.util.ArrayList;

public class MySDK {
    private final String TAG = "MySDK";
    private ArrayList<MyCallBack> callBackList = new ArrayList<>();

    public MySDK(){

    }
    /**
     * 添加回调
     * @param callBack
     */
    public void addCallback(MyCallBack callBack){
        callBackList.add(callBack);
        Log.i(TAG, "addCallback: ");
    }
    /**
     * 移除回调
     * @param callBack
     */
    public void removeCallback(MyCallBack callBack){
        callBackList.remove(callBack);
        Log.i(TAG, "removeCallback: ");
    }
    /**
     * 加法
     * @param a
     * @param b
     */
    public void plus(int a, int b){
        int sum = a + b;
        for (MyCallBack callBack:callBackList) {
                callBack.onPlus(sum,((sum>=0)?true:false));
        }
        Log.i(TAG, "plus: a:"+a+",b:"+b);
    }

    /**
     * 减法
     * @param a
     * @param b
     */
    public void subtract(int a,int b){
        int sub = a - b;
        for (MyCallBack callBack:callBackList) {
            callBack.onSubtract(sub,((sub>=0)?true:false));
        }
        Log.i(TAG, "subtract: a:"+a+",b:"+b);
    }

    /**
     * 获取当前callbacks的数量
     */
    public int  getCallbackSize() {
        int size = callBackList.size();
        Log.i(TAG, "getCallbackSize: current CallbackSize :"+size);
        return size;
    }
}
