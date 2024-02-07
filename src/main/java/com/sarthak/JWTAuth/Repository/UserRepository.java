package com.sarthak.JWTAuth.Repository;

import com.sarthak.JWTAuth.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User>findbyEmail(String email);
}
