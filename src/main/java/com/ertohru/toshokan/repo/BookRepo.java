package com.ertohru.toshokan.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ertohru.toshokan.model.Book;


@Repository
public interface BookRepo extends JpaRepository<Book,Long>{
	
	@Query(value = "SELECT * FROM book WHERE author_id = :author_id",
			nativeQuery=true)
	Page<Book> byAuthorId(@Param("author_id") Long authorId, Pageable page);
	
	@Query(value = "SELECT * FROM book WHERE book_title = :query OR book_synopsis = :query LIMIT 10", nativeQuery=true)
	List<Book> search(@Param("query") String query);
	

}
