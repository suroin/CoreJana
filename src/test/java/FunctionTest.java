import org.testng.annotations.Test;

import java.util.function.Function;

public class FunctionTest {

    Function<Integer,Integer> plus5 = (n) -> n + 5;
    Function<Integer,Integer> square = (n) -> n * n;

    @Test
    public void test1(){
        System.out.println(
                plus5.compose(square).apply(11)
        );
    }
}
