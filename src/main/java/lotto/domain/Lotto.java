package lotto.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static lotto.domain.Winnings.LottoRanking.*;

public class Lotto implements Iterable<LottoNumber> {

    private List<LottoNumber> lottoNumbers;
    private final int LOTTO_LIMIT_COUNT = 6;
    private final String LOTTO_COUNT_OVER_ERROR_MESSAGE = "제한된 개수 이상으로 할당받았습니다.";

    public Lotto(List<Integer> numbers) {
        validateLottoCountRange(numbers);

        lottoNumbers = Collections.unmodifiableList(numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(toList())
        );
    }

    private void validateLottoCountRange(List<Integer> numbers) {
        List<Integer> checkedNumbers = numbers.stream()
                .distinct()
                .collect(toList());

        if(checkedNumbers.size() != LOTTO_LIMIT_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_OVER_ERROR_MESSAGE);
        }
    }

    public Winnings acquireWinnings(Lotto winLotto, LottoNumber bonusNumber) {
        int correspondCount = correspondCount(winLotto);
        int bonusCorrespondCount = bonusCorrespondCount(bonusNumber);
        if(correspondCount != SECOND_PLACE.getCorrespondCount()) {
            bonusCorrespondCount = 0;
        }
        return Winnings.find(correspondCount, bonusCorrespondCount);
    }

    private int correspondCount(Lotto winLotto) {
        return this.lottoNumbers.stream()
                .filter(winLotto::contains)
                .collect(toList())
                .size();
    }

    private int bonusCorrespondCount(LottoNumber bonusNumber) {
        if(contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }

    private boolean contains(LottoNumber number) {
        return this.lottoNumbers.contains(number);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
