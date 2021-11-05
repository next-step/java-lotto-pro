import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {
    final List<Number> data;

    public Numbers(String... numbers) {
        data = new ArrayList<>();

        for (String number : numbers) {
            data.add(new Number(number));
        }
    }

    public int sum() {
        return data.stream()
                .mapToInt(Number::getValue)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers = (Numbers) o;
        return Objects.equals(data, numbers.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
