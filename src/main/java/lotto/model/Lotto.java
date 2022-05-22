package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String PRINT_FORM = "[%s]";
    private static final String PRINT_DELIMITER = ", ";
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 6;

    private final List<LottoNo> pickNumbers;

    public Lotto() {
        pickNumbers = createNumbers();
    }

    public Lotto(Integer... customNumbers) {
        pickNumbers = LottoNo.toLottoNoList(Arrays.asList(customNumbers));
    }

    public Lotto(String customNumbers) {
        pickNumbers = Arrays.stream(customNumbers.split(","))
                .map(String::trim)
                .map(v -> new LottoNo(Integer.parseInt(v))).collect(Collectors.toList());
    }

    public List<LottoNo> seeNumbers() {
        return this.pickNumbers;
    }

    public boolean contain(int number) {
        return this.pickNumbers.stream().anyMatch(lottoNo -> lottoNo.value() == number);
    }

    public String printText() {
        String joinNumber = this.pickNumbers.stream()
                .map(LottoNo::value)
                .map(Object::toString)
                .collect(Collectors.joining(PRINT_DELIMITER));
        return String.format(PRINT_FORM, joinNumber);
    }

    private List<LottoNo> createNumbers() {
        List<Integer> preparedNumbers = LottoNumbers.PREPARED_NUMBERS;
        Collections.shuffle(preparedNumbers);
        return LottoNo.toLottoNoList(preparedNumbers.subList(START_INDEX, END_INDEX));
    }
}
