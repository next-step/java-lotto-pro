package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumbersTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        LottoNumber[] lottoNumbers = createNumbers(new int[]{1, 2, 3, 4, 5, 6});
        lotto = new Lotto(lottoNumbers);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:2:3:4:5:6:6",
            "1:2:3:4:5:7:5",
            "1:2:3:4:7:8:4",
            "1:2:3:7:8:9:3",
            "1:2:7:8:9:10:2",
            "1:7:8:9:10:11:1",
            "7:8:9:10:11:12:0"},
            delimiter = ':')
    void 로또번호와_당첨번호에_따른_매치결과_반환(int input0, int input1, int input2, int input3, int input4, int input5,
                                int matchCount) {
        LottoNumber[] inputs = createNumbers(new int[]{input0, input1, input2, input3, input4, input5});
        WinningNumbers winningNumbers = new WinningNumbers(inputs);

        MatchResult matchResult = winningNumbers.matchWinningLotto(lotto);
        assertThat(matchResult).isEqualTo(MatchResult.from(matchCount));
    }

    @Test
    void 중복_숫자_예외() {
        assertThatThrownBy(() -> new WinningNumbers(createNumbers(new int[]{1, 1, 2, 3, 4, 5}))).isInstanceOf(
                IllegalArgumentException.class);
    }

    private LottoNumber[] createNumbers(int[] inputs) {
        LottoNumber[] lottoNumbers = new LottoNumber[inputs.length];
        for (int index = 0; index < inputs.length; index++) {
            lottoNumbers[index] = LottoNumber.from(inputs[index]);
        }
        return lottoNumbers;
    }
}