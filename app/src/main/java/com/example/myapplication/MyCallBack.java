package com.example.myapplication;

public interface MyCallBack {
    /**
     * 调用加法的回调
     * @param res 结果
     * @param isPositive 是否是正数
     */
    void onPlus(int res,boolean isPositive);

    /**
     * 调用减法的回调
     * @param res 结果
     * @param isPositive 是否是正数
     */
    void onSubtract(int res,boolean isPositive);

}
