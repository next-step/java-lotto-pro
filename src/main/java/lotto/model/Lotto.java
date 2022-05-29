package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final String PRINT_FORM = "[%s]";
    private static final String PRINT_DELIMITER = ", ";
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 6;

    private final Set<LottoNo> pickNumbers;

    public Lotto() {
        pickNumbers = createAutoNumbers();
    }

    public Lotto(Integer... customNumbers) {
        pickNumbers = createNumbers(Arrays.asList(customNumbers));
    }

    public Lotto(String customNumbers) {
        this(Arrays.stream(customNumbers.split(","))
                .map(String::trim).map(Integer::parseInt).toArray(Integer[]::new));
    }

    public Set<LottoNo> numbers() {
        return this.pickNumbers;
    }

    public boolean contain(LottoNo number) {
        return this.pickNumbers.stream().anyMatch(lottoNo -> lottoNo.value() == number.value());
    }

    public String printText() {
        String joinNumber = this.pickNumbers.stream()
                .map(LottoNo::value)
                .map(Object::toString)
                .collect(Collectors.joining(PRINT_DELIMITER));
        return String.format(PRINT_FORM, joinNumber);
    }

    private Set<LottoNo> createAutoNumbers() {
        List<Integer> numbers = LottoNumbers.PREPARED_NUMBERS;
        Collections.shuffle(numbers);
        numbers = numbers.subList(START_INDEX, END_INDEX);
        return createNumbers(numbers);
    }

    private Set<LottoNo> createNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        Set<LottoNo> result = new LinkedHashSet<>();
        for (int number : numbers) {
            result.add(new LottoNo(number));
        }
        if (result.size() != END_INDEX) {
            throw new IllegalArgumentException("숫자는 6개만 입력 가능합니다.");
        }
        return result;
    }
}
