package com.chary.springboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chary.springboot.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
