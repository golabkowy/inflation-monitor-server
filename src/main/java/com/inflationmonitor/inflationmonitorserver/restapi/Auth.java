package com.inflationmonitor.inflationmonitorserver.restapi;

import com.inflationmonitor.inflationmonitorserver.response.SimpleResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class Auth {

    @RequestMapping(method = RequestMethod.GET, path = "/is-logged", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private SimpleResponse isLogged() {
        return new SimpleResponse("is logged works");
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<SimpleResponse> login() {
        return ResponseEntity
                .ok()
                .header("Set-Cookie", "testkey=testvalue")
                .body(new SimpleResponse("test simple response"));
    }
}
