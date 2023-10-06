package me.magliano.shopapi.repository;


import me.magliano.shopapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

    User findUserByName(String name);
    Collection<User> findAllByRole(String role);

}
