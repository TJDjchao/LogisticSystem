package com.neo.logisiticsystem.Dao;

import com.neo.logisiticsystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
