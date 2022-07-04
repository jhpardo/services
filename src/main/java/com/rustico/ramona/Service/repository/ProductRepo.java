package com.rustico.ramona.Service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rustico.ramona.Service.entity.ProductsEntity;

public interface ProductRepo  extends MongoRepository<ProductsEntity, String> {

}
