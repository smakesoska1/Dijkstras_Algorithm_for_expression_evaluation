package ba.unsa.etf.rpr;

/**
 * Input for Dijsktra algorithm for expression evaluation program
 */
public class App 
{
    /**
     * entry method for console application
     * @param args input arguments from console
     * */
    public static void main( String[] args )
    {
        //String proba = "( 1 + ( 5 * 2 ) )";

        String newString = "";
        int size = args.length;
        boolean korektno = true;

        for (int i = 0; i < args.length; i++) {
            if (i == size - 1) {
                newString = newString + args[i];
            } else {
                newString = newString + args[i] + " ";
            }
        }

        validate(newString);


        //System.out.printf("Ispisano je:" + novi);
        //System.out.println(novi.length());
        //System.out.println(proba.length());

        ExpressionEvaluator e=new ExpressionEvaluator();
        Double result=e.evaluate(newString);

        System.out.println(result);

    }

    /**
     * Arithmetic validation for entered String
     * @param example-entered String
     */

    public static void validate(String example) {
        for (int i = 0; i < example.length(); i++) {
            if (i == 0 && example.charAt(i) != '(') {
                throw new RuntimeException("There is no first (main) bracket");
            }
            if (i == example.length() - 1 && example.charAt(i) != ')') {
                throw new RuntimeException("There is no last (main) bracket");
            }
            if(example.charAt(i)=='(' && example.charAt(i+1)!=' '){
                throw new RuntimeException("There is no space behind ( bracket");
            }
            if(example.charAt(i)==')' && example.charAt(i-1)!=' '){
                throw new RuntimeException("There is no space in front of ) bracket");
            }
            if((example.charAt(i)=='*' || example.charAt(i)=='-' || example.charAt(i)=='+' || example.charAt(i)=='/') && (example.charAt(i-1)!=' ' || example.charAt(i+1)!=' ')){
                throw new RuntimeException("There is no space between operands");
            }

        }
    }
}
