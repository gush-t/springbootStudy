package com.example.demo.designpattern.factory.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.designpattern.strategy.service.StrategyPatternService;
import com.example.demo.util.CaculatorUtil;

@RestController
public class FactoryController {

    @RequestMapping("/caculator")
    @ResponseBody
    public BigDecimal caculatorNumber(@RequestParam("firstNub") BigDecimal firstNub, @RequestParam("secondNub") BigDecimal secondNub
            , @RequestParam("operate") String operate) {
        //Double result = CaculatorUtil.caculator(firstNub, secondNub, operate);

        return CaculatorUtil.caculatorPattern(firstNub, secondNub, operate);
    }

    @RequestMapping("/strategy")
    @ResponseBody
    public BigDecimal settleGoods(@RequestParam(value = "tenantIntegral", required = false) BigDecimal tenantIntegral,
                                  @RequestParam(value = "goodsNumber") BigDecimal goodsNumber,
                                  @RequestParam(value = "goodsPrice") BigDecimal goodsPrice,
                                  @RequestParam(value = "settleMode") String settleMode
    ) {
        StrategyPatternService strategy = StrategyPatternService.createStrategyPatter(settleMode, tenantIntegral);
        return strategy.getAccounts(goodsNumber, goodsPrice);
    }
}
