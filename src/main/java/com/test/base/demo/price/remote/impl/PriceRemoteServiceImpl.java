package com.test.base.demo.price.remote.impl;

import com.test.base.demo.price.remote.PriceRemoteService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


/**
 * @author liguanghui9105
 */
@Service
public class PriceRemoteServiceImpl implements PriceRemoteService {
    @Override
    public BigDecimal getPriceById(Long id) {
        return BigDecimal.valueOf(id);
    }
}
