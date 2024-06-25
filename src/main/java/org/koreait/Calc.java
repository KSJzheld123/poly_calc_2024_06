package org.koreait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {
    public static int run(String exp) {

        List<String> bits = new ArrayList<>(List.of(exp.split(" ")));
        List<String> middle = new ArrayList<>(List.of(exp.split(" ")));
        List<String> first =  new ArrayList<>(List.of(exp.split("")));
        List<String> last =  new ArrayList<>(List.of(exp.split("")));
        first.removeAll(Arrays.asList(" "));
        int result = 0;
        int index = 0;

        if((middle.get(0).contains("("))) {
            middle.set(0, "n");
            bits.set(0, "n");
        } else {
            result = Integer.parseInt(middle.get(0));
        }

        first.removeAll(Arrays.asList(")"));

        for(int i = 0; i < first.size(); i++) {
            int a = 0;
            int b = 0;
            int c = 0;
            if(first.contains("(")) {
                if(first.get(i+1).contains("(")) {
                } else {
                    a = Integer.parseInt(first.get(i+1));
                    b = Integer.parseInt(first.get(i+3));
                    if(first.get(i+2).contains("*")) {
                        c = a * b;
                        first.set(i+3, String.valueOf(c));
                        first.set(i+2, "n");
                        first.set(i+1, "n");
                    } else if (first.get(i+2).contains("/")) {
                        c = a / b;
                        first.set(i+3, String.valueOf(c));
                        first.set(i+2, "n");
                        first.set(i+1, "n");
                    } else if (first.get(i+2).contains("+")) {
                        c = a + b;
                        first.set(i+3, String.valueOf(c));
                        first.set(i+2, "n");
                        first.set(i+1, "n");
                    } else if (first.get(i+2).contains("-")) {
                        c = a - b;
                        first.set(i+3, String.valueOf(c));
                        first.set(i+2, "n");
                        first.set(i+1, "n");
                    }
                }
            }
        }

        first.removeAll(Arrays.asList("n"));

//

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
        } else {
            for(int a = 0; a < bits.size(); a++) {
                if (bits.get(a).contains("+")) {
                    result += Integer.parseInt(bits.get(a+1));
                } else if(bits.get(a).contains("-")) {
                    result -= Integer.parseInt(bits.get(a+1));
                }
            }
        }

        if(first.size() == last.size()) {
            return result;
        } else {
            middle.clear();
            middle.addAll(first);
            return result;
        }

    }
}