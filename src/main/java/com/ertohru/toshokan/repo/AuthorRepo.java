package com.ertohru.toshokan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ertohru.toshokan.model.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {

}
