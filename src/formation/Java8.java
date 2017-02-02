package formation;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


interface MyComputation<T> {
  T compute(T n, T m);
}

public class Java8 {
  public static void main(String[] args) {

    List<MyComputation<Integer>> computations =
        Arrays.asList(
            (Integer n, Integer m)-> n+m,
            (n, m)-> n*m,
            (n, m)-> { return n-m; }
        );
    computations.forEach((comp) -> System.out.println(comp.compute(10, 4)));

    List<Integer> ints = Arrays.asList(1, 2, 3);
    long cnt = ints.stream().map(x-> "Hello" + x).filter(x -> x.length() > 10).count();
    List<String> strings = ints.stream().map(x-> "Hello" + x).collect(Collectors.toList());
  }
}

Class.method(x)
x.method

