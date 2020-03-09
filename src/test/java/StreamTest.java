import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {

    @Test
    public void test(){
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            integerList.add(i);
        }

        integerList.
                stream().
                filter((i) ->{
                    System.out.println("Filter: " + i);
                    return i%2 == 0;
                }).
                limit(3).
                map((i) -> {
                    System.out.println("map: " + i);
                    return i*i;
                }).
                forEach(i -> System.out.println(i));
    }

    @Test
    public void testSort(){
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            integerList.add(i);
        }

        integerList.
                stream().
                filter((i) ->{
                    System.out.println("Filter: " + i);
                    return i%2 == 0;
                }).

                limit(3).
                sorted().
                map((i) -> {
                    System.out.println("map: " + i);
                    return i*i;
                }).
                forEach(i -> System.out.println(i));
    }


    @Test
    public void testPeek(){
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            integerList.add(i);
        }

        integerList.
                stream().
                skip(3).
                peek((i) -> System.out.println("peek:  " + i)).
                filter((i) -> i%2 == 0).
                peek((i) -> System.out.println("peek after filtering: " + i)).
                limit(3).
                peek((i) -> System.out.println("peek after limit: " + i)).
                map((i) -> i*i);
              //  forEach(i -> System.out.println(i));
    }

    @Test
    public void testFlatMap() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        List<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(5);
        b.add(6);

        List<Integer> c = new ArrayList<>();
        b.add(7);
        b.add(8);
        b.add(9);

        List<List<Integer>> abc = new ArrayList<>();
        abc.add(a);
        abc.add(b);
        abc.add(c);

        abc.stream()
                .flatMap(l -> l.stream())
                .map(i -> i * i)
                .forEach( System.out::println);
    }
}
