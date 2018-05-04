package com.ggy.springboot.jpa;

import com.ggy.springboot.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface TradeJPA extends
        JpaRepository<Trade,String>,JpaSpecificationExecutor<Trade>,Serializable{
}
