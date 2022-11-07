package study.step3;

import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    private List<LottoNumber> lottoNumbers;
    private Lottos lottos;

    @BeforeEach
    @DisplayName("로또번호 5자리 셋팅")
    public void setup() {
        lottos = new Lottos(new ArrayList<>());
        lottoNumbers = new ArrayList<>();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(45));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(18));

    }

    @Test
    @DisplayName("로또번호 6개를 저장한다.")
    public void 로또번호_저장() {
        lottoNumbers.add(new LottoNumber(20));

        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("로또번호 중복 입력 시 Exception발생")
    public void 로또번호_중복번호_체크() {
        lottoNumbers.add(new LottoNumber(1));

        assertThatThrownBy(() ->
                new Lotto(lottoNumbers)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 중복 발행 불가능 합니다");
    }

    @Test
    @DisplayName("로또번호가 6자리가 입력 되지 않으면 Exception")
    public void 로또번호_6자리_체크() {
        assertThatThrownBy(() ->
                new Lotto(lottoNumbers)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 6개 입력 되어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,10,3,4,7,19:3", "1,45,3,4,7,19:4", "1,45,3,4,18,19:5", "1,45,3,4,18,20:6"}, delimiter = ':')
    @DisplayName("로또번호 맞춘 갯수 검증")
    public void 로또번호_맞춘개수_검증(String given, int collectNumber) {
        WinLotto winLotto = new WinLotto(given, new LottoNumber(41));
        lottoNumbers.add(new LottoNumber(20));
        Lotto lotto = new Lotto(lottoNumbers);
        lottos.add(lotto);

        int expectValue = lotto.countCollectNumber(winLotto.getWinLottoNumbers(), winLotto.getBonusNumber()).getCollectCount();

        assertThat(expectValue).isEqualTo(collectNumber);
    }

}
