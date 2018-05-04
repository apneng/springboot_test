package com.ggy.springboot.jpa;

import com.ggy.springboot.entity.Trade;
import com.ggy.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

public interface UserJPA  extends
        JpaRepository<User,String>,
        JpaSpecificationExecutor<User>,
        Serializable {
}
