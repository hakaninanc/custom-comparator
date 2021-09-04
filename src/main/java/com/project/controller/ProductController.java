package com.project.controller;

import com.project.model.Product;
import com.project.rest.model.ProductRequest;
import com.project.rest.model.ProductResponse;
import com.project.rest.model.RestResponse;
import com.project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/product")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/sort")
    public ResponseEntity<RestResponse<ProductResponse>> sortProducts(@RequestBody ProductRequest request) {

        final List<Product> products = productService.allProcesses(request.getProducts(), request.getCriteria());
        final ProductResponse productResponse = new ProductResponse(products);

        return ResponseEntity.ok(RestResponse.of(productResponse));
    }

}
