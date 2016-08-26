package com.airconomist.frontendmail.domain.payment.zooz;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public enum CurrencyCodeISO {
    GBP, USD, EUR;

    public static final Set<CurrencyCodeISO> SUPPORTED_CURRENCY_CODES = Stream.of(CurrencyCodeISO.GBP).collect(Collectors.toSet());
}
