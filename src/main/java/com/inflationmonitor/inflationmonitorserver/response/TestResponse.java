package com.inflationmonitor.inflationmonitorserver.response;

import java.util.List;

public class TestResponse {
    String stringVal;
    Double doubleVal;
    double[] doubleArr;
    List<TestPOJO> listPOJO;

    public TestResponse(String stringVal, Double doubleVal, double[] doubleArr, List<TestPOJO> listPOJO) {
        this.stringVal = stringVal;
        this.doubleVal = doubleVal;
        this.doubleArr = doubleArr;
        this.listPOJO = listPOJO;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public Double getDoubleVal() {
        return doubleVal;
    }

    public void setDoubleVal(Double doubleVal) {
        this.doubleVal = doubleVal;
    }

    public double[] getDoubleArr() {
        return doubleArr;
    }

    public void setDoubleArr(double[] doubleArr) {
        this.doubleArr = doubleArr;
    }

    public List<TestPOJO> getListPOJO() {
        return listPOJO;
    }

    public void setListPOJO(List<TestPOJO> listPOJO) {
        this.listPOJO = listPOJO;
    }
}
