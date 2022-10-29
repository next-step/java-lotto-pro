package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.statistics.WinningLottoType;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("기본 - 1장에 1000원짜리 로또를 생성한다.")
    void createDefaultLotto() {
        Lotto lotto = new Lotto(new LottoNumbers());
        assertThat(lotto.getPrice()).isEqualTo(1000);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST:1, 2, 3, 4, 5, 6",
            "SECOND:1, 2, 3, 4, 5, 10",
            "THIRD:1, 2, 3, 4, 10, 20",
            "FOURTH:1, 2, 3, 10, 20, 30",
            "NOTHING:1, 2, 10, 20, 30, 40"}, delimiter = ':')
    @DisplayName("로또 당첨 결과를 리턴한다.")
    void test(String type, String input) {
        LottoNumbers lottoNumbers = new LottoNumbers(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        );
        Lotto lotto = new Lotto(lottoNumbers);
        WinningLottoType winningLottoType = lotto.getWinningLottoType(new WinningLottoNumbers(input));
        assertThat(winningLottoType.name()).isEqualTo(type);
    }
}
