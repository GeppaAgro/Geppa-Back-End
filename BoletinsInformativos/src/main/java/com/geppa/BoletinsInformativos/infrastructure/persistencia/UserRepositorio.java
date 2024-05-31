package com.geppa.BoletinsInformativos.infrastructure.persistencia;

import com.geppa.BoletinsInformativos.infrastructure.model.security.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepositorio extends JpaRepository<UserModel, Long> {

    @Query("SELECT u FROM UserModel u WHERE u.userName = :userName")
    UserModel findByUserName(@Param("userName") String userName);

}