package step2;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(String[] numberTexts) {
        if (numberTexts == null || numberTexts.length == 0) throw new RuntimeException();
        this.numbers = getCarsFromInputName(numberTexts);
    }

    private List<Number> getCarsFromInputName(String[] numberTexts) {
        List<Number> result = new ArrayList<>();
        for (String numberText : numberTexts) {
            result.add(new Number(numberText));
        }
        return result;
    }

    public List<Number> numbers() {
        return this.numbers;
    }
}
