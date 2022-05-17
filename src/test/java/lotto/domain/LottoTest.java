package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    public void 로또_생성자_리스트() {
        List<LottoNo> lottoNoList = Arrays.asList(
                new LottoNo(1),
                new LottoNo(10),
                new LottoNo(15),
                new LottoNo(27),
                new LottoNo(35),
                new LottoNo(45));
        new Lotto(lottoNoList);
    }

    @Test
    public void 로또_가변_인자로_생성_테스트() {
        List<LottoNo> lottoNoList = Arrays.asList(
                new LottoNo(1),
                new LottoNo(10),
                new LottoNo(15),
                new LottoNo(27),
                new LottoNo(35),
                new LottoNo(45));

        Lotto actual = new Lotto(lottoNoList);
        Lotto expected = new Lotto(1, 10, 15, 27, 35, 45);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 로또_문자열_인자로_생성_테스트() {
        List<LottoNo> lottoNoList = Arrays.asList(
                new LottoNo(1),
                new LottoNo(10),
                new LottoNo(15),
                new LottoNo(27),
                new LottoNo(35),
                new LottoNo(45));

        Lotto actual = new Lotto(lottoNoList);
        Lotto expected = new Lotto("1, 10, 15, 27, 35, 45");
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 10, 20, 30, 40, 50", "-1, 10, 20, 30, 40, 45"})
    public void 로또_생성_테스트_비정상(String lottoNumbers) {
        assertThatThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 3, 4, 5, 6", "1, 1, 1, 1, 1, 1", "1, 1, 1, 2, 2, 2"})
    public void 로또_생성_테스트_중복_비정상(String lottoNumbers) {
        assertThatThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_번호_비교_테스트_1등() {
        Lotto myLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNo bonusNumber = new LottoNo(30);

        Ranking ranking = myLotto.compareLotto(winningLotto, bonusNumber);

        assertThat(ranking).isEqualTo(Ranking.FIRST);
    }

    @Test
    public void 로또_번호_비교_테스트_보너스_미포함() {
        Lotto myLotto = new Lotto("1, 2, 3, 4, 5, 45");
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNo bonusNumber = new LottoNo(10);

        Ranking ranking = myLotto.compareLotto(winningLotto, bonusNumber);

        assertThat(ranking).isEqualTo(Ranking.THIRD);
    }

    @Test
    public void 로또_번호_비교_테스트_보너스_포함() {
        Lotto myLotto = new Lotto("1, 2, 3, 4, 5, 45");
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNo bonusNumber = new LottoNo(45);

        Ranking ranking = myLotto.compareLotto(winningLotto, bonusNumber);

        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }
}
