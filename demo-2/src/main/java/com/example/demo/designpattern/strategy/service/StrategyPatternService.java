package com.example.demo.designpattern.strategy.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategyPatternService {

    @Autowired
    private SettleAccounts settleAccounts;

    public static StrategyPatternService createStrategyPatter(String settleMode, BigDecimal tenantIntegral) {
        StrategyPatternService strategy = new StrategyPatternService();
        switch (settleMode) {
            case "正常模式":
                strategy = new StrategyPatternService(new SettelNormal());
                break;

            case "积分模式":
                strategy = new StrategyPatternService(new SettleIntegral(tenantIntegral.intValue()));
                break;

            default:
                break;
        }

        return strategy;

    }

    public StrategyPatternService() {
        super();
    }


    public StrategyPatternService(SettleAccounts settleAccounts) {
        super();
        this.settleAccounts = settleAccounts;
    }

    public BigDecimal getAccounts(BigDecimal goodsNumber, BigDecimal goodsPrice) {
        return this.settleAccounts.settleCashAccounts(goodsNumber, goodsPrice);
    }

    public SettleAccounts getSettleAccounts() {
        return settleAccounts;
    }

    public void setSettleAccounts(SettleAccounts settleAccounts) {
        this.settleAccounts = settleAccounts;
    }

}
