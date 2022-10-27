package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
}
