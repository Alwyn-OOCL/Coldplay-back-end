package com.oocl.coldplay.repository;

import com.oocl.coldplay.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String userName);
    Optional<User> findByEmail(String email);


}
