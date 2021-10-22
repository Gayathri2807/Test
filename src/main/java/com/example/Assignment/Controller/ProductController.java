package com.example.Assignment.Controller;

import com.example.Assignment.Model.Product;
import com.example.Assignment.Model.ProductOutput;
import com.example.Assignment.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
   /* @GetMapping("/getProductList")
    public List<Product> getProductList() throws ParseException {
        return productService.getProductList();
    }

    */

    @PostMapping("/sortProducts")
    public List<Product> sortProducts(@RequestBody List<Product> productOutput) {
        //productService.getProductList();
        return productService.sortProducts(productOutput);

    }
}