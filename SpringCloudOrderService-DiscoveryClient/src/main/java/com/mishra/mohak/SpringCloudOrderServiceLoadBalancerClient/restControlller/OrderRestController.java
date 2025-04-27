package com.mishra.mohak.SpringCloudOrderServiceLoadBalancerClient.restControlller;

import com.mishra.mohak.SpringCloudOrderServiceLoadBalancerClient.consumer.CartConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/orders")
public class OrderRestController {

    @Autowired
    private CartConsumer cartConsumer;

    @GetMapping("/place")
    public ResponseEntity<String> placeOrder() {
        String response= cartConsumer.getCartService();
        return ResponseEntity.ok("order got placed"+response);
    }
}