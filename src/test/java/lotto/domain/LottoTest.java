package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    private Set<LottoNumber> prizeNumbers;
    private LottoNumber bonusNumber;
    private int NUMBER_COUNT;

    @BeforeEach
    void setUp() {
        NUMBER_COUNT = 6;
        prizeNumbers = new HashSet<>();
        prizeNumbers.add(LottoNumber.from(1));
        prizeNumbers.add(LottoNumber.from(2));
        prizeNumbers.add(LottoNumber.from(3));
        prizeNumbers.add(LottoNumber.from(4));
        prizeNumbers.add(LottoNumber.from(5));
        prizeNumbers.add(LottoNumber.from(6));

        bonusNumber = LottoNumber.from(45);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:2:3:4:5:6:false:6",
            "1:2:3:4:5:45:true:5",
            "1:2:3:4:5:7:false:5",
            "1:2:3:4:7:8:false:4",
            "1:2:3:7:8:9:false:3",
            "1:2:7:8:9:10:false:2",
            "1:7:8:9:10:11:false:1",
            "7:8:9:10:11:12:false:0"},
            delimiter = ':')
    void 로또번호와_당첨번호에_따른_매치결과_반환(int input0, int input1, int input2, int input3, int input4, int input5,
                                boolean isBonus, int matchCount) {

        Lotto lotto = createLotto(new int[]{input0, input1, input2, input3, input4, input5});
        MatchResult matchResult = lotto.match(prizeNumbers, bonusNumber);
        assertThat(matchResult).isEqualTo(MatchResult.of(matchCount, isBonus));
    }

    @Test
    void 정렬된_로또_번호_반환() {
        Lotto lotto = createLotto(new int[]{3, 4, 1, 2, 5, 6});
        assertThat(lotto.sortLottoNumbers()).containsExactly(getLottoNumbers(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 중복_숫자_예외() {
        assertThatThrownBy(() -> createLotto(new int[]{1, 1, 2, 3, 4, 5})).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3:4:5:6:7:7"}, delimiter = ':')
    void 숫자_개수_예외(int input0, int input1, int input2, int input3, int input4, int input5, int input6) {

        assertThatThrownBy(
                () -> createLotto(new int[]{input0, input1, input2, input3, input4, input5, input6})).isInstanceOf(
                IllegalArgumentException.class);
    }

    private LottoNumber[] getLottoNumbers(int input0, int input1, int input2, int input3, int input4, int input5) {
        LottoNumber[] lottoNumbers = new LottoNumber[NUMBER_COUNT];
        lottoNumbers[0] = LottoNumber.from(input0);
        lottoNumbers[1] = LottoNumber.from(input1);
        lottoNumbers[2] = LottoNumber.from(input2);
        lottoNumbers[3] = LottoNumber.from(input3);
        lottoNumbers[4] = LottoNumber.from(input4);
        lottoNumbers[5] = LottoNumber.from(input5);
        return lottoNumbers;
    }

    private Lotto createLotto(int[] inputs) {
        LottoNumber[] lottoNumbers = new LottoNumber[inputs.length];

        for (int index = 0; index < inputs.length; index++) {
            lottoNumbers[index] = LottoNumber.from(inputs[index]);
        }

        return new Lotto(lottoNumbers);
    }

}