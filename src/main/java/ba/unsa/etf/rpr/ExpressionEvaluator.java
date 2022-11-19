package ba.unsa.etf.rpr;

import java.util.*;

/**
 * Class for expression evaluation
 */

public class ExpressionEvaluator {
    private String str;
    private Stack<String> ops = new Stack<>();
    private Stack<Double> vals = new Stack<>();

    /**
     * default contructor
     * */
    public ExpressionEvaluator() {
    }

    public String getStr() {
        return str;
    }

    public void setStr(String stri) {
        this.str = stri;
    }


    public Stack<String> getOps() {
        return ops;
    }

    public void setOps(Stack<String> ops) {
        this.ops = ops;
    }

    public Stack<Double> getVals() {
        return vals;
    }

    public void setVals(Stack<Double> vals) {
        this.vals = vals;
    }

    /**
     *
     * @param s-parsed String
     * @return result of Dijkstra algorithm- Double value
     */

    public Double evaluate(String s) {
        String[] str = s.split(" ");

        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(str));

        Queue<String> queue = new LinkedList<>(strList);

        while (!queue.isEmpty()) {
            String t = queue.poll();
            if (t.equals("(")) {
            } else if (t.equals("+")) {
                this.ops.push(t);
            } else if (t.equals("-")) {
                this.ops.push(t);
            } else if (t.equals("*")) {
                this.ops.push(t);
            } else if (t.equals("/")) {
                this.ops.push(t);
            } else if (t.equals("sqrt")) {
                this.ops.push(t);
            } else if (t.equals(")")) {
                double v = this.vals.pop();
                String op = this.ops.pop();
                if (op.equals("+")) {
                    v = this.vals.pop() + v;
                } else if (op.equals("-")) {
                    v = this.vals.pop() - v;
                } else if (op.equals("*")) {
                    v = this.vals.pop() * v;
                } else if (op.equals("/")) {
                    v = this.vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                this.vals.push(v);
            } else {
                this.vals.push(Double.parseDouble(t));
            }
        }
        return (this.vals.pop());
    }
}
