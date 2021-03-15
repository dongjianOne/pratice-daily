package com.dong.utils;

import java.math.BigDecimal;

/**
 * @author dong
 * @version 1.0
 */
@FunctionalInterface
public interface ToBigDecimalFunction<T> {

    /**
     * Applies this function to the given argument.
     *
     * @param value the function argument
     * @return the function result
     */
    BigDecimal applyAsBigDecimal(T value);
}
