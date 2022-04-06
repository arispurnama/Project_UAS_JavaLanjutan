package com.neo.sihotel.repository;

import com.neo.sihotel.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    Optional<User> findById(String id);

    @Query("SELECT u from User u where u.email = : email")
    public User getUserByEmail(@Param("email") String email);
}