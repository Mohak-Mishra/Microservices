package com.mishra.mohak.consumer;

import com.mishra.mohak.bean.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("CartService")
public interface CartConsumer {

    @GetMapping("/v1/api/cart/show")
    public ResponseEntity<String> getProduct();

    @GetMapping("/v1/api/cart/find/{id}")
    public ResponseEntity<Cart>getByCartId(@PathVariable("id")Integer id);

    @PostMapping("/v1/api/cart/create")
    public ResponseEntity<String> addToCart(@RequestBody Cart cart);
}
