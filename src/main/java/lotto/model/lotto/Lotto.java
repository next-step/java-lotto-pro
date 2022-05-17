package lotto.model.lotto;

import static lotto.constant.LottoSetting.LOTTO_SIZE;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.winning.WinningLotto;

public class Lotto {

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumberSet) {
        validateSize(lottoNumberSet);
        this.lottoNumbers = lottoNumberSet;
    }

    public static Lotto of(Set<LottoNumber> lottoNumberSet) {
        return new Lotto(lottoNumberSet);
    }

    public static Lotto of(String[] lottoStringArr) {
        Set<LottoNumber> lottoNumberSet = Arrays.stream(lottoStringArr)
            .map(LottoNumber::new)
            .collect(Collectors.toSet());

        return of(lottoNumberSet);
    }

    public int match(Lotto lotto) {
        return (int) lottoNumbers.stream().filter(lotto::contains).count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 숫자는 %d개가 필요합니다.", LOTTO_SIZE));
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}
