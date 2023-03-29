package com.connectto.repositores;


import com.connectto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByEmail(String email);

    @Query(value = "SELECT u FROM User u LEFT JOIN Book b on (u.id=b.user.id) WHERE (b.flight.id = ?1)")
    List<User> getUserbyFlight(Long id);
}
