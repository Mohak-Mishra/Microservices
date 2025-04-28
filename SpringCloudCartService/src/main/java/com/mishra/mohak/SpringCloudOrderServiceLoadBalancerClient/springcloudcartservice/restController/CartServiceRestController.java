package com.mishra.mohak.SpringCloudOrderServiceLoadBalancerClient.springcloudcartservice.restController;

import com.mishra.mohak.SpringCloudOrderServiceLoadBalancerClient.springcloudcartservice.bean.Cart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/cart")
public class CartServiceRestController {
    @Value("${server.port}")
    String port;
    @GetMapping("/show")
    public ResponseEntity<String> getProduct() {
        return new ResponseEntity<>(" This is the product "+port, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Cart>getByCartId(@PathVariable("id")Integer id) {
        Cart cart = new Cart();
        cart.setCartCode("TEST");
        cart.setCartCost(1000.0);
        cart.setCartId(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);

    }
    @PostMapping("/create")
    public ResponseEntity<String> addToCart(@RequestBody Cart cart){


        return new ResponseEntity(cart.toString(),HttpStatus.CREATED);

    }

}
