package com.myfirstapi.repository;

import com.myfirstapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u from User u where u.id > :id")
    List<User> findAllMoreThan(@Param("id") Long id);

    List<User> findByIdGreaterThan(Long id);

    List<User> findByName(String name);

}
