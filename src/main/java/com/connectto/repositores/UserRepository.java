package com.connectto.repositores;


import com.connectto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByEmail(String email);

    @Query(value = "SELECT * FROM USER WHERE id IN (SELECT user_id FROM book WHERE flight_id = ?1)",nativeQuery = true)
    List<User> getUserbyFlight(Long id);
}
