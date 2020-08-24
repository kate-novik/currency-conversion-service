package com.novik.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * CurrencyConversionController.
 * @author Kate Novik
 */
@RestController
public class CurrencyConversionController {

  @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversionBean convertCurrency(@PathVariable String from,
      @PathVariable String to,
      @PathVariable BigDecimal quantity) {

    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);
    CurrencyConversionBean response = new RestTemplate().getForObject(
        "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
        CurrencyConversionBean.class, uriVariables);

    return new CurrencyConversionBean(response.getId(), from, to,
        response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), 0);
  }

}
