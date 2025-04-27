package com.mishra.mohak.springcloudcartservice.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/cart")
public class CartServiceRestController {
    @GetMapping("/show")
    public ResponseEntity<String> getProduct() {
        return new ResponseEntity<>(" This is the product ", HttpStatus.OK);
    }

}
