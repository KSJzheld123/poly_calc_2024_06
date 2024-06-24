package org.koreait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Calc {
    public static int run(String exp) {

        boolean needToPlus = exp.contains("+");
        boolean needToMinus = exp.contains("-");


        String[] bits = null;
        int c = 0;


        if(needToPlus) {
            bits = exp.split(" \\+ ");
        } else if(needToMinus) {
            bits = exp.split(" - ");
        }

        if(bits.length > 2) {
            c = Integer.parseInt(bits[2]);
        }

        if(needToPlus) {
            int a = Integer.parseInt(bits[0]);
            int b = Integer.parseInt(bits[1]);
            return a + b + c;
        } else if(needToMinus) {
            int a = Integer.parseInt(bits[0]);
            int b = Integer.parseInt(bits[1]);
            return a - b - c;
        }

        throw new RuntimeException("해석 불가");

    }

}
