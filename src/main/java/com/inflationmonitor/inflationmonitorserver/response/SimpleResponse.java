package com.inflationmonitor.inflationmonitorserver.response;

public class SimpleResponse {
    public String text;

    public SimpleResponse(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
