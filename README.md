# 목표
- 3 * 1 + (1 - (4 * 1 - (1 - 1)))


else {
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