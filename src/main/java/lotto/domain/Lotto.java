package lotto.domain;

import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoNumber.LOTTO_MIN_NUMBER;

public class Lotto {
    private static final List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        this.lottoNumbers = LOTTO_NUMBERS.stream()
                .limit(LOTTO_NUMBERS_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }

    public Lotto(String input) {
        String[] inputArr = input.replace(" ", "").split(",");
        vaildCount(inputArr);
        List<LottoNumber> list = new ArrayList<>();
        for (String s : inputArr) {
            list.add(new LottoNumber(s));
        }
        Collections.sort(list);
        this.lottoNumbers = list;
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public int match(Lotto target) {
        int count = 0;
        for (LottoNumber lottoNumber : target.getLottoNumbers()) {
            if (this.lottoNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    private void vaildCount(String[] input) {
        Set<String> set = new HashSet<>();
        for (String s : input) {
            set.add(s);
        }
        if (set.size() != 6) {
            OutputView.printErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
