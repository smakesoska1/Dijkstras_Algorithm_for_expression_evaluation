package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionEvaulatorTest {


        @Test
        public void test1(){
            String string=new String("( ( 1 + 2 ) * 3 )");
            Assertions.assertEquals(9.0,ExpressionEvaluator.evaluate(string));
        }


        @Test
        public void test2(){
            String string=new String("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
            Assertions.assertEquals(101.0,ExpressionEvaluator.evaluate(string));
        }

        @Test
        public void test3(){
            String string=new String("( ( 0 + 0 ) * 3 )");
            Assertions.assertEquals(0.0,ExpressionEvaluator.evaluate(string));
        }



        @Test
        public void test4(){
            String string=new String("( 1 + ( 5 * 20 ) )");
            Assertions.assertEquals(101.0,ExpressionEvaluator.evaluate(string));
        }

    @Test
    public void test5(){
        String string=new String("1 + ( 5 * 20 ) )");
        Assertions.assertThrows(RuntimeException.class,()->App.validate(string),"There is no first (main) bracket");
    }

    @Test
    public void test6(){
        String string=new String("( 1 + ( 5 * 20 ) ");
        Assertions.assertThrows(RuntimeException.class,()->App.validate(string),"There is no last (main) bracket");
    }

    @Test
    public void test7(){
        String string=new String("( 5 + ( 5 +100 ) )");
        Assertions.assertThrows(RuntimeException.class,()->App.validate(string),"There is no space between operands");
    }

    @Test
    public void test8(){
        String string=new String("( 1 + (( 2 + 3 ) * ( 4 * 5 ) ) )");
        Assertions.assertThrows(RuntimeException.class,()->App.validate(string),"There is no space behind ( bracket");
    }

    @Test
    public void test9(){
        String string=new String("( 1 + ( ( 2 + 3 ) * ( 4 * 5 )))");
        Assertions.assertThrows(RuntimeException.class,()->App.validate(string),"There is no space in front of ) bracket");
    }



    }

