package com.inflationmonitor.inflationmonitorserver.restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inflationmonitor.inflationmonitorserver.data.entities.Product;
import com.inflationmonitor.inflationmonitorserver.data.repositories.ProductRepository;
import com.inflationmonitor.inflationmonitorserver.response.PaginatedProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;
//    PageableHandlerMethodArgumentResolver
//    PageRequest ok to ma szanse rozwiazywac problem, ma w parametrze page, size, sort

    @GetMapping(value = {"/test-not-restricted", "/test-not-restricted/{id}"})
    private String testNotRestrictedAccess(@PathVariable(name = "id", required = false) String id,
                                           @RequestParam(name = "testParam1", defaultValue = "defaultValue testParam1", required = false) String testParam1,
                                           @RequestParam(name = "testParam2", defaultValue = "defaultValue testParam2") String testParam2) {
        return "Response for not restricted access GET Request endpoint " + testParam1 + " " + testParam2 + " ID:" + id;
    }

    @GetMapping(value = {"/products"})
    private ResponseEntity getAllProducts() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonStringShort = objectMapper.writeValueAsString(new ResponseShort("OK"));
//        String jsonStringFull = objectMapper.writeValueAsString(new ResponseFull("OK"));
//        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jsonStringFull);
        return ResponseEntity.ok().body(productRepository.findAllCustom());
    }

    @GetMapping(value = "/pageable")
//    private ResponseEntity<Page<Product>> readProductsPagable(@RequestParam("customParam") String param, Pageable pageable) {
    private ResponseEntity<Page<Product>> readProductsPagable(Pageable pageable) {
        return ResponseEntity.ok().body(productRepository.findAll(pageable));
    }

    @GetMapping(value = "/custom-response", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<PaginatedProductResponse> readProductsPagableCustom(Pageable pageable) {
        double[] testArr = {2.1, 2.2, 2.3, 2.3, 2.5};
        return ResponseEntity
                .ok(new PaginatedProductResponse(productRepository.findAll(pageable).toList(), 5, "testCustom", testArr));
    }
}
