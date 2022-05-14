package lottoauto.wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Lotto {
    List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto(String[] checkRegex) {
        numbers = new ArrayList<>();
        IntStream.range(0, checkRegex.length).forEach(i -> numbers.add(Integer.parseInt(checkRegex[i])));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int size() {
        return numbers.size();
    }

    public int get(int index) {
        return numbers.get(index);
    }

    public boolean contains(Object o) {
        return numbers.contains(o);
    }
}
