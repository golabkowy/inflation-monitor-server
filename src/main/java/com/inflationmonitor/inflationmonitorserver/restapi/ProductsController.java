package com.inflationmonitor.inflationmonitorserver.restapi;

import com.inflationmonitor.inflationmonitorserver.data.entities.Product;
import com.inflationmonitor.inflationmonitorserver.data.entities.ProductType;
import com.inflationmonitor.inflationmonitorserver.data.repositories.ProductRepository;
import com.inflationmonitor.inflationmonitorserver.data.repositories.ProductTypeRepository;
import com.inflationmonitor.inflationmonitorserver.response.PaginatedProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductsController(ProductRepository productRepository, ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
    }
//    PageableHandlerMethodArgumentResolver
//    PageRequest ok to ma szanse rozwiazywac problem, ma w parametrze page, size, sort

    @GetMapping(value = {"/test-not-restricted", "/test-not-restricted/{id}"})
    private String testNotRestrictedAccess(@PathVariable(name = "id", required = false) String id,
                                           @RequestParam(name = "testParam1", defaultValue = "defaultValue testParam1", required = false) String testParam1,
                                           @RequestParam(name = "testParam2", defaultValue = "defaultValue testParam2") String testParam2) {
        return "Response for not restricted access GET Request endpoint " + testParam1 + " " + testParam2 + " ID:" + id;
    }

    @GetMapping(value = {"/products"})
    private ResponseEntity getAllProducts() {
        return ResponseEntity.ok().body(productRepository.findAllCustom());
    }

    @GetMapping(value = {"/products-by-phrase"})
    private ResponseEntity<Iterable<Product>> getProductsByPhrase(@RequestParam(name = "phrase") String phrase) {
        return ResponseEntity.ok().body(productRepository.findAllByNameStartsWith(phrase));
    }

    @GetMapping(value = "/pageable")
    private ResponseEntity<Page<Product>> readProductsPagable(Pageable pageable) {
        return ResponseEntity.ok().body(productRepository.findAll(pageable));
    }

    @GetMapping(value = "/custom-response", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<PaginatedProductResponse> readProductsPagableCustom(Pageable pageable) {
        double[] testArr = {2.1, 2.2, 2.3, 2.3, 2.5};
        return ResponseEntity
                .ok(new PaginatedProductResponse(productRepository.findAll(pageable).toList(), 5, "testCustom", testArr));
    }

    @GetMapping(value = "/product-types", produces = MediaType.APPLICATION_JSON_VALUE)
    private HttpEntity<List<ProductType>> listAllProductTypes() {
        return new HttpEntity<List<ProductType>>(productTypeRepository.findAll());
    }

    @PostMapping(value = "/add-new-product-type")
    private void addNewProductType(@RequestBody Product product) {
        productRepository.save(product);
    }
}
