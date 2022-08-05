package com.restaurants.restaurants.repositories;


import com.restaurants.restaurants.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmailId(String emailId);
    Optional<UserEntity> findByPhoneNumber(String phoneNumber);
    Boolean existsByEmailId(String emailId);
    Boolean existsByPhoneNumber(String phoneNumber);
}
