package com.mishra.mohak.restController;

import com.mishra.mohak.bean.Cart;
import com.mishra.mohak.consumer.CartConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/v1/api/order")
public class OrderRestController {
    @Autowired
    private CartConsumer consumer;

    @GetMapping("/place")
    public ResponseEntity<String> placeOrder(){
        String s=consumer.getProduct().getBody();
       return  ResponseEntity.ok("order got placed "+s);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<String> find(@PathVariable("id") Integer id){
        Cart cart=consumer.getByCartId(id).getBody();
        return new ResponseEntity<>(cart.toString(),HttpStatus.OK);
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestBody Cart cart){
        String res= consumer.addToCart(cart).getBody();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }


}
