package com.linjianfu.chapter16;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.math.BigDecimal;
import java.util.Arrays;

public class Sixteen17 {
    public static class BigDecimalGenerator implements Generator<BigDecimal> {

        private BigDecimal bigDecimal = new BigDecimal(0.0);

        @Override
        public BigDecimal next() {
            return bigDecimal = bigDecimal.add(new BigDecimal(4.0));
        }
    }

    public static void main(String[] args) {
        BigDecimalGenerator bigDecimalGenerator = new BigDecimalGenerator();
        System.out.println(Arrays.asList(Generated.array(BigDecimal.class, bigDecimalGenerator, 3)));
        BigDecimal[] bigDecimals = new BigDecimal[3];
        System.out.println(Arrays.asList(Generated.array(bigDecimals, bigDecimalGenerator)));
    }
}
