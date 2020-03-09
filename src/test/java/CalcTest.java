import org.testng.annotations.Test;

public class CalcTest {

    public static int calculate(int x,MathOperation mathOperation,int y){
        return mathOperation.operate(x,y);
    }

    @Test
    public void test(){
        MathOperation add = (x,y) -> x + y;

        System.out.println(calculate(5,add,7));
    }
}
