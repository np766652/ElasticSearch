package com.example.elasticsearch.controller;

import com.example.elasticsearch.entity.Product;
import com.example.elasticsearch.services.ProductServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/search")
public class ElasticSearchController {

    @Autowired
    ProductServices productServices;


    @GetMapping(value = "/findAll")
    List<Product> findAll() {
        return productServices.findAll();
    }

    @GetMapping(value = "/random/{string}")
    List<Product> getAll(@PathVariable("string")  String string) {
        System.out.println("Random Search");
        return productServices.getAll(string);
    }

    @GetMapping(value = "/id/{Id}")
    public Optional<Product> findById(@PathVariable("Id") String id) {
        return productServices.findById(id);
    }

    @GetMapping(value = "/product/{product}")
    List<Product> findByProduct(@PathVariable("product")  String product) {
        return productServices.findByProduct(product);
    }
    @GetMapping(value = "/inches/{inches}")
    List<Product> findByInches(@PathVariable("inches")  int inches) {
        return productServices.findByInches(inches);
    }


    @GetMapping(value = "/screen/{screen}")
    List<Product> findByScreenResolution(@PathVariable("screen")  String screen) {
        return productServices.findByScreenResolution(screen);
    }
    @GetMapping(value = "/ram/{ram}")
    List<Product> findByRam(@PathVariable("ram")  String ram) {
        return productServices.findByRam(ram);
    }
    @GetMapping(value = "/weight/{weight}")
    List<Product> findByWeight(@PathVariable("weight")  String weight) {
        return productServices.findByWeight(weight);
    }
    @GetMapping(value = "/opSys/{opSys}")
    List<Product> findByopSys(@PathVariable("opSys")  String opSys) {
        return productServices.findByOpSys(opSys);
    }
    @GetMapping(value = "/company/{company}")
    List<Product> findByCompany(@PathVariable("company")  String company) {
        return productServices.findByCompany(company);
    }
    @GetMapping(value = "/type/{type}")
    List<Product> findByTypeName(@PathVariable("type")  String type) {
        return productServices.findByTypeName(type);
  }
    @GetMapping(value = "/memory/{memory}")
    List<Product> findByMemory(@PathVariable("memory")  String memory) {
        return productServices.findByMemory(memory);
    }
    @GetMapping(value = "/price/{price}")
    List<Product> findByPrice(@PathVariable("price")  int price) {
        return productServices.findByPrice(price);

    }
    @GetMapping(value = "/gpu/{gpu}")
    List<Product> findByGpu(@PathVariable("gpu")  String gpu) {
        return productServices.findByGpu(gpu);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productServices.save(product);
    }

    @KafkaListener(topics = "sendtosearch",groupId = "team7")
    public void saveProduct(String string)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        Product product=null;
        try {
            product = objectMapper.readValue(string.getBytes(),Product.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(product.toString());
        productServices.save(product);
    }

}
