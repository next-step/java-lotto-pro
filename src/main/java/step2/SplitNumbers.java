package step2;

import java.util.List;
import java.util.stream.Collectors;

public class SplitNumbers {

    private final List<SplitNumber> splitNumbers;

    public SplitNumbers(List<SplitNumber> splitNumbers) {
        this.splitNumbers = splitNumbers;
    }

    public List<Integer> getSplitNumbers() {
        return splitNumbers.stream()
                .map(splitNumber -> splitNumber.getSplitNumber())
                .collect(Collectors.toList());
    }
}
