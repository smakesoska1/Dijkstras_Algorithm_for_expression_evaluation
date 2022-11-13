package ba.unsa.etf.rpr;

import java.util.*;

public class ExpressionEvaluator {
    private String str;

    public ExpressionEvaluator() {
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static Double evaluate(String s) {
        String[] str = s.split(" ");

        ArrayList<String> strList = new ArrayList<String>(
                Arrays.asList(str));

        Queue<String> queue = new LinkedList<>(strList);

        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        while (!queue.isEmpty()) {
            String t = queue.poll();
            if (t.equals("(")) {
            } else if (t.equals("+")) {
                ops.push(t);
            } else if (t.equals("-")) {
                ops.push(t);
            } else if (t.equals("*")) {
                ops.push(t);
            } else if (t.equals("/")) {
                ops.push(t);
            } else if (t.equals("sqrt")) {
                ops.push(t);
            } else if (t.equals(")")) {
                double v = vals.pop();
                String op = ops.pop();
                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                vals.push(v);
            } else {
                vals.push(Double.parseDouble(t));
            }
        }
        return (vals.pop());
    }
}
