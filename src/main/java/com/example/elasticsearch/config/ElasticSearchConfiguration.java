package com.example.elasticsearch.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(value = "com.example.elasticsearch.repository")
public class ElasticSearchConfiguration {


}
