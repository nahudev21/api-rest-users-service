package com.Nahudev.user_service_apiRest.repository;

import com.Nahudev.user_service_apiRest.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
}
