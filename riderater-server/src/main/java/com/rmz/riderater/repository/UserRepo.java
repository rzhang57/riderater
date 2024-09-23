package com.rmz.riderater.repository;

import com.rmz.riderater.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    // create - use save(user)

    // retrieve
    Optional<User> findById(int id);
    Optional<User> findByGoogleId(String googleId);
    Optional<User> findByEmail(String email);

    // update - save(user)

    // delete - delete(user)
}
