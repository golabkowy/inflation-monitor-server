package com.inflationmonitor.inflationmonitorserver.restapi;

import com.inflationmonitor.inflationmonitorserver.response.SimpleResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

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

    // get all oauth2 info
    @GetMapping("/userInfo")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttributes();
    }
}
