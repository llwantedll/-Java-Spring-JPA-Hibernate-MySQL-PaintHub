package com.llwantedll.dao;

import com.llwantedll.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    User findByLogin(String login);
    User findByEmail(String email);
}
