package com.example.Assignment.Service;

import com.example.Assignment.Model.Product;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private static List<Product> productList = new ArrayList<>();

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    /*

    public List<Product> getProductList() throws ParseException {
        Date date1, date2, date3, date4;
        date1 = dateFormat.parse("2021-02-19");
        date2 = dateFormat.parse("2021-02-21");
        date3 = dateFormat.parse("2021-02-22");
        date4 = dateFormat.parse("2021-02-24");

        productList.add(new Product("Prod2","Trousers","EACH",dateFormat.format(date1)));
        productList.add(new Product("Prod1","Shirt","EACH",dateFormat.format(date2)));
        productList.add(new Product("Prod3","Tie","EACH",dateFormat.format(date2)));
        productList.add(new Product("Prod3","Tie","EACH",dateFormat.format(date4)));

        return productList;
    }
     */
    public List<Product> sortProducts(List<Product> productOutput){
        System.out.println(productOutput);
        List<Product> sortedProductList = productOutput.stream()
                .sorted(Comparator.comparing(Product::getProductId).thenComparing(Product::getLaunchDate).reversed())
                .collect(Collectors.toList());

        return sortedProductList;
    }
}

