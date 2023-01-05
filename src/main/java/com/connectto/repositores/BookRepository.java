package com.connectto.repositores;

import com.connectto.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  //  @Query(nativeQuery = true, value = "DELETE from book  where id in(SELECT id from book where flight_id = 54)")
   // void deleteByFlight(Long id);

}
