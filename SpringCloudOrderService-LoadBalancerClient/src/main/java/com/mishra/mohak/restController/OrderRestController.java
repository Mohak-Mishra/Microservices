package com.mishra.mohak.restController;

import com.mishra.mohak.consumer.CartConsumer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/order")

public class OrderRestController {


    private CartConsumer cartConsumer=new CartConsumer();

    @GetMapping("/place")
    public ResponseEntity<String> placeOrder()  {
        String response= cartConsumer.getCartService();
        return ResponseEntity.ok("order got placed"+response);
    }
}
