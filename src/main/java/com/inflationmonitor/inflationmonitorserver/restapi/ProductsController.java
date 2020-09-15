package com.inflationmonitor.inflationmonitorserver.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @Autowired
    private OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    @GetMapping(value = {"/test-not-restricted", "/test-not-restricted/{id}"})
    private String testNotRestrictedAccess(@PathVariable(name = "id", required = false) String id,
                                           @RequestParam(name = "testParam1", defaultValue = "defaultValue testParam1", required = false) String testParam1,
                                           @RequestParam(name = "testParam2", defaultValue = "defaultValue testParam2") String testParam2) {
        return "Response for not restricted access GET Request endpoint " + testParam1 + " " + testParam2 + " ID:" + id;
    }

    @GetMapping(value = {"/test-restricted"})
    private String testRestrictedAccess() {
        return "Response for not restricted access GET Request endpoint";
    }

    @GetMapping("/test-oAuth2-token")
    public void testOAuth2Credentials(OAuth2AuthenticationToken token) {
        OAuth2AuthorizedClient client = oAuth2AuthorizedClientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(), token.getName());
    }

    @GetMapping("/test-principal")
    public String testPrincipal(@AuthenticationPrincipal OAuth2User user) {
        return user.getAttributes().toString();
    }
}
