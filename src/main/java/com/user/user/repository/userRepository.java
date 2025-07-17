package com.user.user.repository;

import com.user.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface userRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);
}
