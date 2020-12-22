package com.inflationmonitor.inflationmonitorserver.response;

import java.util.HashSet;

public class Response {
    private String description;
    private String status;
    public HashSet lol;

    public Response(String description, String status) {
        this.description = description;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
