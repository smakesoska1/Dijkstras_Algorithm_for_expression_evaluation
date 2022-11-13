package ba.unsa.etf.rpr;

/**
 * Hello world!
 *
 */
public class App 
{
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


        //System.out.printf("Ispisano je:" + novi);
        //System.out.println(novi.length());
        //System.out.println(proba.length());

        /*for (int i = 0; i < velicina; i++) {
            if (i % 2 == 1 && proba.charAt(i) != ' ') {
                korektno = false;
                break;
            }
            if (i == 0 && proba.charAt(i) != '(') {
                korektno = false;
                break;
            }
        }

        if (korektno) {
            System.out.println("Sve ok");
        } else {
            throw new RuntimeException("Nije sve ok");
        }*/

        Double result=ExpressionEvaluator.evaluate(newString);

        System.out.println(result);

    }
}
