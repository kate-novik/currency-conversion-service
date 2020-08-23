package com.novik.microservices.currencyconversionservice;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CurrencyConversionBean.
 * @author Kate Novik
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrencyConversionBean {
  private Long id;
  private String from;
  private String to;
  private BigDecimal conversionMultiple;
  private BigDecimal quantity;
  private BigDecimal totalCalculatedAmount;
  private int port;

}
