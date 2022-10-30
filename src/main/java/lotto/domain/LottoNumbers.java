package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final static int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        checkSizeLottoNumber(lottoNumbers);
        checkDuplicatedLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    private void checkSizeLottoNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호 입력은 6개의 숫자로 이루어져야 합니다.");
        }
    }

    private void checkDuplicatedLottoNumber(List<Integer> lottoNumbers) {
        Set<Integer> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumberSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복이 될 수 없습니다.");
        }
    }

    public List<Integer> match(LottoNumbers lottoNumbers) {
        List<Integer> duplicates = new ArrayList<>(numbers());
        duplicates.retainAll(lottoNumbers.numbers());
        return duplicates;
    }

    public List<Integer> numbers() {
        return this.lottoNumbers
                .stream()
                .map(LottoNumber::toString)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public boolean isBonusMatch(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

}
