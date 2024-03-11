package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sample.dto.BoatTicketDTO;
import com.sample.entity.User;
import com.sample.entity.UserInfo;

import java.util.Optional;
import java.util.List;


public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);





}
 