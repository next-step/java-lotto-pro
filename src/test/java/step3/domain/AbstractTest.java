package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import step3.utils.NumbersGenerator;

public class AbstractTest {

    protected static List<Number> start1NumberList;
    protected static List<Number> start4NumberList;
    protected static List<Number> exceptNumberList;
    protected static List<Number> duplicatedNumberList;

    protected static UniqueNumbers start1Numbers;
    protected static UniqueNumbers start4Numbers;
    protected static UniqueNumbers exceptNumbers;
    protected static UniqueNumbers randomNumbers;

    static {
        start1NumberList = generateLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        start4NumberList = generateLottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));
        exceptNumberList = generateLottoNumbers(Arrays.asList(1, 2, 3));
        duplicatedNumberList = generateLottoNumbers(Arrays.asList(1, 1, 1, 1, 1, 1));

        start1Numbers = UniqueNumbers.generate(start1NumberList);
        start4Numbers = UniqueNumbers.generate(start4NumberList);
        exceptNumbers = UniqueNumbers.generate(exceptNumberList);
        randomNumbers = NumbersGenerator.random();
    }

    protected static List<Number> generateLottoNumbers(List<Integer> selectNumbers) {
        return selectNumbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
