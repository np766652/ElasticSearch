package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {


    Product save(Product product);


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

}

