package com.test.base.demo.price.remote;

import java.math.BigDecimal;

public interface PriceRemoteService {

    BigDecimal getPriceById(Long id);
}
