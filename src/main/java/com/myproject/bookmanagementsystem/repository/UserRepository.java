package com.myproject.bookmanagementsystem.repository;

import com.myproject.bookmanagementsystem.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, PagingAndSortingRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    @Query(
            value = "select u from User u where u.email like %:email%"
    )
    Page<User> findByEmailContains(@Param("email") String email, Pageable pageable);

    @Query(
            value = "select u from User u where u.username like %:username%"
    )
    Page<User> findByUsernameContains(@Param("username") String username, Pageable pageable);

}
