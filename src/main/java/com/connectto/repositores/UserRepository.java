package com.connectto.repositores;


import com.connectto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM USER WHERE id IN " +
            "(SELECT user_id FROM book WHERE flight_id IN " +
            "(SELECT id FROM flight WHERE airplane_id = ?1 ))")
    List<User> getUserbyFlight(Long id);
}
