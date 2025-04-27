package com.mishra.mohak.SpringCloudOrderServiceLoadBalancerClient.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
public class CartConsumer {

    @Autowired
    DiscoveryClient discoveryClient;

    public String getCartService() throws RestClientException {
        // Getting details based on service name of microservices
        List<ServiceInstance> instances = discoveryClient.getInstances("SpringCloudCartService");

        // get the details of service instance
        ServiceInstance serviceInstance = instances.get(0);
        // based on instance get the uri
        URI uri = serviceInstance.getUri();
        // with uri create url
        String path = uri+"/v1/api/cart/show";

        //use rest template and get the output
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> re=restTemplate.getForEntity(path, String.class);

        return re.getBody();
    }
}
