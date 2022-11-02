package study.step3;

import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinLottoTest {
    private List<LottoNumber> lottoNumbers;
    private Lotto lotto;

    private Lottos lottos;

    @BeforeEach
    public void inputLottoSetup() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(45));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(18));
        lottoNumbers.add(new LottoNumber(20));

        lotto = new Lotto(lottoNumbers);
        lottos = new Lottos(new ArrayList<>());

    }

    @ParameterizedTest
    @CsvSource(value = {"1,10,3,4,7,19:3", "1,45,3,4,7,19:4", "1,45,3,4,18,19:5", "1,45,3,4,18,20:6"}, delimiter = ':')
    @DisplayName("로또번호 맞춘 갯수 검증")
    public void 로또번호_맞춘개수_검증(String given, int collectNumber) {
        WinLotto winLotto = new WinLotto(given);

        lottos.add(lotto);

        WinReport winReport = winLotto.findWinner(lottos);
        assertThat(winReport.getLottoResult(collectNumber)).isEqualTo(1);
    }

}