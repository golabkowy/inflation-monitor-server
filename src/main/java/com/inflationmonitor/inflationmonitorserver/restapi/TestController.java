package com.inflationmonitor.inflationmonitorserver.restapi;

import com.inflationmonitor.inflationmonitorserver.data.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/")
    private String testGetBasicPath() {
        return "GET works BasicPath";
    }

    @GetMapping(value = "/testGET")
    private String testGet() {
        return "GET works";
    }

    @GetMapping(value = "/testGITForm")
    private String testGetForm() {
        return "GET works FORM";
    }

    @GetMapping(value = "/testGETDenny")
    private String testGetDeny() {
        return "GET works Deny";
    }

    @PostMapping(value = "/testPOST")
    private String testPost() {
        return "POST works";
    }

    // SECURITY TESTS


    @GetMapping("/test-oAuth2-token")
    public void testOAuth2Credentials(OAuth2AuthenticationToken token) {
        OAuth2AuthorizedClient client = oAuth2AuthorizedClientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(), token.getName());
    }

    @GetMapping("/test-principal")
    public String testPrincipal(@AuthenticationPrincipal OAuth2User user) {
        return user.getAttributes().toString();
    }

    @RequestMapping("/test-secure-denyAll")
    public String testGetSecurityDenyAll() {
        return "You have na access to test-source method";
    }

    @RequestMapping("/test-secure-form")
    public String testGetSecurityLoginFormRole() {
        return "You have na access to test-source method";
    }

}
