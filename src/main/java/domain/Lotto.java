package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        isValidLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void isValidLottoNumbers(List<LottoNumber> lottoNumbers){
        isValidDuplicateLottoNumbers(lottoNumbers);
        isValidSizeNotEqualsLottoNumber(lottoNumbers);
    }

    private void isValidDuplicateLottoNumbers(List<LottoNumber> lottoNumbers){
        if(new HashSet<>(lottoNumbers).size() != lottoNumbers.size()){
            throw new IllegalArgumentException("로또번호는 중복 발행 불가능 합니다");
        }
    }

    private void isValidSizeNotEqualsLottoNumber(List<LottoNumber> lottoNumbers){
        if(lottoNumbers.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또번호는 6개 입력 되어야 합니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers(){
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
