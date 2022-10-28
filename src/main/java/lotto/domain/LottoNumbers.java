package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        if(lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자만 설정 가능합니다.");
        }
        if(new HashSet<>(lottoNumbers).size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호가 중복됩니다.");
        }
        this.lottoNumbers = lottoNumbers;
        Collections.sort(lottoNumbers);
    }

    public long getCorrectCount(List<Integer> numbers) {
        return lottoNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
