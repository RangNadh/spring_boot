package io.springboot.mongodb.connection.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.springboot.mongodb.connection.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
