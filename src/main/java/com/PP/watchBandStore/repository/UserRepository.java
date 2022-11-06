package com.PP.watchBandStore.repository;

import com.PP.watchBandStore.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmailAndPassword(String email,String password);
    boolean existsByEmail(String email);
    User findByEmail(String email);

}
