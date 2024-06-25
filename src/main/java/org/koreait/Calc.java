package org.koreait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {
    public static int run(String exp) {

        List<String> bits = new ArrayList<>(List.of(exp.split(" ")));
        List<String> middle =new ArrayList<>(List.of(exp.split(" ")));
        int result = 0;
        int index = 0;
        result = Integer.parseInt(middle.get(0));

        for(int i = 1; i < middle.size(); i++) {
            int a = 0;
            if(middle.get(i).contains("*")) {
                a = Integer.parseInt(middle.get(i-1)) * Integer.parseInt(middle.get(i+1));
                middle.set(i+1, String.valueOf(result));
                middle.set(i,"n");
                middle.set(i-1,"n");
                middle.set(i+1, String.valueOf(a));

            } else if(middle.get(i).contains("/")) {
                a = Integer.parseInt(middle.get(i-1)) / Integer.parseInt(middle.get(i+1));
                middle.set(i+1, String.valueOf(result));
                middle.set(i,"n");
                middle.set(i-1,"n");
                middle.set(i+1, String.valueOf(a));
            }
        }

        middle.removeAll(Arrays.asList("n"));
        int count = 0;

        for(int i = 0; i < middle.size(); i++) {
            if(middle.contains("+")) {
                count++;
            } else if (middle.contains("-")) {
                count++;
            }
        } if(count == 0) {
            result = Integer.parseInt(middle.get(index));
        }

        if(bits.size() != middle.size()) {
            for(int a = 0; a < middle.size(); a++) {
                if (middle.get(a).contains("+")) {
                    result += Integer.parseInt(middle.get(a+1));
                } else if(middle.get(a).contains("-")) {
                    result -= Integer.parseInt(middle.get(a+1));
                }
            }
        } else if(bits.size() == middle.size()) {
            for(int a = 0; a < bits.size(); a++) {
                if (bits.get(a).contains("+")) {
                    result += Integer.parseInt(bits.get(a+1));
                } else if(bits.get(a).contains("-")) {
                    result -= Integer.parseInt(bits.get(a+1));
                }
            }
        }

        return result;

    }
}