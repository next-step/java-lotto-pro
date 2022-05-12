import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Number calculateSum() {
        Number result = new Number();
        for (Number number : numbers) {
            result = result.addNumber(number);
        }
        return result;
    }

}
