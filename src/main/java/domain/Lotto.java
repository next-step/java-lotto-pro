package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> LottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        isValidLottoNumbers(lottoNumbers);
        LottoNumbers = lottoNumbers;
    }

    private void isValidLottoNumbers(List<Integer> lottoNumbers){
        isValidDuplicateLottoNumbers(lottoNumbers);
        isValidSizeNotEqualsLottoNumber(lottoNumbers);
    }

    private void isValidDuplicateLottoNumbers(List<Integer> lottoNumbers){
        if(new HashSet<>(lottoNumbers).size() != lottoNumbers.size()){
            throw new IllegalArgumentException("로또번호는 중복 발행 불가능 합니다");
        }
    }

    private void isValidSizeNotEqualsLottoNumber(List<Integer> lottoNumbers){
        if(lottoNumbers.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또번호는 6개 입력 되어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(LottoNumbers, lotto.LottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LottoNumbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "LottoNumbers=" + LottoNumbers +
                '}';
    }
}
