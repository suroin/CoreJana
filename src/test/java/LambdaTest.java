import org.testng.annotations.Test;

import java.util.Objects;

public class LambdaTest {

    public static void fn1(LambdaExpression lambdaExpression){

        System.out.println("Inside function:");
        String string = lambdaExpression.foo();
        System.out.println("static fn: " + string);
    }

    public static LambdaExpression getLambda(){
        System.out.println("Inside get Lambda");
        return () -> "Bobotik";

    }

    @Test
    public void LambdaTest1(){
        LambdaExpression lambdaExpression = () ->  {
            System.out.println("aaaa");
            System.out.println("aaaa");
            return "false";
        };
        LambdaExpression lambdaExpression1;


        fn1(() -> {
            System.out.println("Inside lambda");
            return "Hi";
        });

        fn1(lambdaExpression);
        System.out.println(lambdaExpression.foo());




    }

    @Test public void lambdaTest2(){
        String string = getLambda().foo();

        System.out.println(string);

    }

    @Test public void methodRefTest(){

        MethReference methReference =  Objects::isNull;
        System.out.println(methReference.method(null));
       

    }
}
