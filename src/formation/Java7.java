package formation;

import java.util.Arrays;
import java.util.List;

interface Computation<T> {
  T compute(T n, T m);
}

class IntSum implements Computation<Integer> {

  @Override
  public Integer compute(Integer n, Integer m) {
    return n + m;
  }

}

class IntProduct implements Computation<Integer> {

  @Override
  public Integer compute(Integer n, Integer m) {
    return n * m;
  }
}

class IntDifference implements Computation<Integer> {

  @Override
  public Integer compute(Integer n, Integer m) {
    return n - m;
  }
}

public class Java7 {

  public static void main(String[] args) {

    List<Computation> computations =
        Arrays.asList(
            new IntSum(),
            new IntDifference(),
            new IntProduct()
        );

    for (Computation comp : computations) {
      System.out.println(comp.compute(10,4));
    }
  }
}
