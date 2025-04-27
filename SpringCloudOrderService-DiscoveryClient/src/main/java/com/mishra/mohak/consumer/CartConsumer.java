package com.mishra.mohak.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
public class CartConsumer {

    @Autowired
    LoadBalancerClient client;
    public String getCartService(){

        ServiceInstance instance= client.choose("CartService");

        URI uri= instance.getUri();

        String path= uri+ "/v1/api/cart/show";

        //use rest template and get the output
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> re=restTemplate.getForEntity(path, String.class);

        return re.getBody();
    }
}
