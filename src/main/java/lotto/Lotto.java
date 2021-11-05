package lotto;

import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lotto implements Iterable<LottoNumber> {

    private List<LottoNumber> lottoNumbers;
    private final int LIMIT_COUNT = 6;
    private final String LOTTO_COUNT_OVER_ERROR_MESSAGE = "제한된 개수 이상으로 할당받았습니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        lottoNumbers = numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(toList());
    }

    private void validate(List<Integer> numbers) {
        if(numbers.isEmpty() || numbers.size() > LIMIT_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_OVER_ERROR_MESSAGE);
        }
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
