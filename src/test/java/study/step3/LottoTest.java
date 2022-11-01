package study.step3;

import domain.Lotto;
import domain.LottoNumber;
import domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    private List<LottoNumber> lottoNumbers;

    @Test
    @DisplayName("로또번호 6개를 저장한다.")
    public void 로또번호_저장() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(45));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(18));
        lottoNumbers.add(new LottoNumber(20));

        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("로또번호 중복 입력 시 Exception발생")
    public void 로또번호_중복번호_체크() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(45));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(18));
        lottoNumbers.add(new LottoNumber(20));

        assertThatThrownBy(() ->
                new Lotto(lottoNumbers)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 중복 발행 불가능 합니다");
    }

    @Test
    @DisplayName("로또번호가 6자리가 입력 되지 않으면 Exception")
    public void 로또번호_6자리_체크() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(45));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(18));

        assertThatThrownBy(() ->
                new Lotto(lottoNumbers)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 6개 입력 되어야 합니다.");
    }

}
