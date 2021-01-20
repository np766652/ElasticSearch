package com.example.elasticsearch.services.impl;

import com.example.elasticsearch.entity.Product;
import com.example.elasticsearch.repository.ProductRepository;
import com.example.elasticsearch.services.ProductServices;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImpl implements ProductServices {




    @Autowired
    ProductRepository productRepository;
    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;


    @Override
    public List<Product> findByCompany(String company) {
        return productRepository.findByCompany(company);
    }

    @Override
    public List<Product> findByProduct(String product) {
        return productRepository.findByProduct(product);
    }

    @Override
    public List<Product> findByTypeName(String typeName) {
        return productRepository.findByTypeName(typeName);
    }

    @Override
    public List<Product> findByInches(double inches) {
        return productRepository.findByInches(inches);
    }

    @Override
    public List<Product> findByScreenResolution(String screenResolution) {
        return productRepository.findByScreenResolution(screenResolution);
    }

    @Override
    public List<Product> findByRam(String ram) {
        return productRepository.findByRam(ram);
    }

    @Override
    public List<Product> findByMemory(String memory) {
        return productRepository.findByMemory(memory);
    }

    @Override
    public List<Product> findByGpu(String gpu) {
        return productRepository.findByGpu(gpu);
    }

    @Override
    public List<Product> findByOpSys(String opSys) {
        return productRepository.findByOpSys(opSys);
    }

    @Override
    public List<Product> findByWeight(String weight) {
        return productRepository.findByWeight(weight);
    }

    @Override
    public List<Product> findByPrice(int price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public List<Product> findAll() {
        Iterable<Product> employees = productRepository.findAll();
        List<Product> employeeList = new ArrayList<>();
        employees.forEach(employeeList::add);
        return employeeList;
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAll(String text) {
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().should(QueryBuilders.queryStringQuery(text)
                .lenient(true).field("company").field("product").field("typename").field("inches").field("price").field("ram").field("memory").field("gpu").field("opSys").field("weight").field("price").field("screenResolution"))
                .should(QueryBuilders.queryStringQuery("*" + text + "*")
                        .lenient(true).field("company").field("product").field("typename").field("inches").field("price").field("ram").field("memory").field("gpu").field("opSys").field("weight").field("price").field("screenResolution"));
        NativeSearchQuery nativeSearchQuery= new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        //System.out.println(nativeSearchQuery.getQuery());
        List<Product> productList = elasticsearchRestTemplate.queryForList(nativeSearchQuery, Product.class, IndexCoordinates.of("mysearch"));
        return productList;
    }
      @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
