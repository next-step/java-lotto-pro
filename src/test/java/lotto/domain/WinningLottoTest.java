package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTest {
    
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        LottoNumber[] lottoNumbers = createNumbers(new int[]{1, 2, 3, 4, 5, 6});
        lotto = new Lotto(lottoNumbers);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:2:3:4:5:6:45:false:6",
            "1:2:3:4:5:7:6:true:5",
            "1:2:3:4:5:7:45:false:5",
            "1:2:3:4:7:8:45:false:4",
            "1:2:3:7:8:9:45:false:3",
            "1:2:7:8:9:10:45:false:2",
            "1:7:8:9:10:11:45:false:1",
            "7:8:9:10:11:12:45:false:0"},
            delimiter = ':')
    void 로또번호와_당첨번호에_따른_매치결과_반환(int input0, int input1, int input2, int input3, int input4, int input5,
                                int bonusNumber, boolean isBonus, int matchCount) {
        LottoNumber[] inputs = createNumbers(new int[]{input0, input1, input2, input3, input4, input5});
        WinningLotto winningNumbers = new WinningLotto(inputs, LottoNumber.from(bonusNumber));
        MatchResult matchResult = MatchResult.of(matchCount, isBonus);
        assertThat(winningNumbers.isMatched(lotto, matchResult)).isEqualTo(true);
    }

    @Test
    void 중복_숫자_예외() {
        assertThatThrownBy(
                () -> new WinningLotto(createNumbers(new int[]{1, 1, 2, 3, 4, 5}), LottoNumber.from(45))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 보너스_중복_숫자_예외() {
        assertThatThrownBy(
                () -> new WinningLotto(createNumbers(new int[]{1, 2, 3, 4, 5, 6}), LottoNumber.from(1))).isInstanceOf(
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