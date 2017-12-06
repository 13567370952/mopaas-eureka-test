package com.didispace.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
    
    @RequestMapping("/registered")  
    public String getRegistered(){  
    	List<String> serviceList = client.getServices();
    	for (String string : serviceList) {
			System.out.println(string);
		}
//        List<ServiceInstance> list = discoveryClient.getInstances("STORES");  
//        System.out.println(discoveryClient.getLocalServiceInstance());  
//        System.out.println("discoveryClient.getServices().size() = " + discoveryClient.getServices().size());  
//          
//        for( String s :  discoveryClient.getServices()){  
//            System.out.println("services " + s);  
//            List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(s);  
//            for(ServiceInstance si : serviceInstances){  
//                System.out.println("    services:" + s + ":getHost()=" + si.getHost());  
//                System.out.println("    services:" + s + ":getPort()=" + si.getPort());  
//                System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());  
//                System.out.println("    services:" + s + ":getUri()=" + si.getUri());  
//                System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());  
//            }  
//              
//        }  
//          
//        System.out.println(list.size());  
//        if (list != null && list.size() > 0 ) {  
//            System.out.println( list.get(0).getUri()  );  
//        }  
        return null;  
    }  

}