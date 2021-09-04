package com.project;

import com.project.model.Product;
import com.project.rest.model.ProductRequest;
import com.project.service.ProductService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;

@SpringBootTest
class CustomComparatorApplicationTests {

    private ProductService productService = new ProductService();

    @Test
    void sort() throws UnsupportedEncodingException {
        ProductRequest request = getRequest();
        List<Product> products = request.getProducts();
        String criteria = request.getCriteria();

        productService.allProcesses(products, criteria);

        System.out.println(products);

    }

    @Test
    void parser() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("sample.json");
        Reader reader = new InputStreamReader(is, "UTF-8");
        Gson gson = new Gson();
        ProductRequest productRequest = gson.fromJson(reader, ProductRequest.class);
        System.out.println(productRequest);
    }


    private ProductRequest getRequest() throws UnsupportedEncodingException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("sample.json");
        Reader reader = new InputStreamReader(is, "UTF-8");
        Gson gson = new Gson();
        ProductRequest productRequest = gson.fromJson(reader, ProductRequest.class);
        return productRequest;
    }


}
