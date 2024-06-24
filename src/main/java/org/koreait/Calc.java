package org.koreait;

public class Calc {
    public static int run(String exp) {

        boolean needToPlus = exp.contains("+");
        boolean needToMinus = exp.contains("-");

        String[] bits = null;

        if(needToPlus) {
            bits = exp.split(" \\+ ");
        } else if(needToMinus) {
            bits = exp.split(" - ");
        }

        if(needToPlus) {
            int a = Integer.parseInt(bits[0]);
            int b = Integer.parseInt(bits[1]);
            return a + b;
        } else if(needToMinus) {
            int a = Integer.parseInt(bits[0]);
            int b = Integer.parseInt(bits[1]);
            return a - b;
        }

        throw new RuntimeException("해석 불가");

    }

}
