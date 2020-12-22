package com.inflationmonitor.inflationmonitorserver.response;

public class TestPOJO {
    String stringProp;
    Double doubleProp;
    int[] intArrProp;

    public TestPOJO(String stringProp, Double doubleProp, int[] intArrProp) {
        this.stringProp = stringProp;
        this.doubleProp = doubleProp;
        this.intArrProp = intArrProp;
    }

    public String getStringProp() {
        return stringProp;
    }

    public void setStringProp(String stringProp) {
        this.stringProp = stringProp;
    }

    public Double getDoubleProp() {
        return doubleProp;
    }

    public void setDoubleProp(Double doubleProp) {
        this.doubleProp = doubleProp;
    }

    public int[] getIntArrProp() {
        return intArrProp;
    }

    public void setIntArrProp(int[] intArrProp) {
        this.intArrProp = intArrProp;
    }
}
