package com.example.elasticsearch.services;

import com.example.elasticsearch.entity.Product;

import javax.naming.Reference;
import java.util.List;
import java.util.Optional;

public interface ProductServices {

    List<Product> findByCompany(String company);

    List<Product> findByProduct(String product);

    List<Product> findByTypeName(String typeName);

    List<Product> findByInches(double inches);

    List<Product> findByScreenResolution(String screenResolution);

    List<Product> findByRam(String ram);

    List<Product> findByMemory(String memory);

    List<Product> findByGpu(String gpu);

    List<Product> findByOpSys(String opSys);

    List<Product> findByWeight(String weight);

    List<Product> findByPrice(int price);

    List<Product> findAll();



    Product save(Product product);

    Optional<Product> findById(String id);

    List<Product> getAll(String string);

}
