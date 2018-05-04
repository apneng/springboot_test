package com.ggy.springboot.ctrl;

import com.ggy.springboot.entity.Trade;
import com.ggy.springboot.jpa.TradeJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/trade")
public class TradeCtrl {
    @Autowired
    private TradeJPA tradeJPA;

    /**查找全部
     * @return
     */
    @RequestMapping(value = "/tradeList",method = RequestMethod.GET)
    public List<Trade> tradeList(){
        return tradeJPA.findAll();
    }

    /**更新用户
     * @param trade
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public List<Trade> save(Trade trade){
        trade.setId(UUID.randomUUID().toString().replace("-",""));
        tradeJPA.save(trade);
        return tradeJPA.findAll();
    }

    /**删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<Trade> delete(String id){
        tradeJPA.deleteById(id);
        return tradeJPA.findAll();
    }
}
