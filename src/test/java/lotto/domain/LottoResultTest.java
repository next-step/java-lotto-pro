package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(
                new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
    }

    @DisplayName("로또 결과 테스트")
    @ParameterizedTest(name = "{displayName} -> number: {0}, expected: {1}")
    @CsvSource(value = {
            "1,2,3,4,5,6:6"
            , "1,2,3,4,5,10:5"
            , "1,2,3,4,10,11:4"
            , "1,2,3,10,11,12:3"
            , "1,2,10,11,12,13:2"
            , "1,10,11,12,13,14:1"
            , "10,11,12,13,14,15:0"
    }, delimiter = ':')
    void lottoResult(String input, int key) {
        // when
        String[] stringNumbers = input.split(LottoMachine.NUMBER_DELIMITER);
        Lotto lotto = new Lotto();
        for (String stringNumber : stringNumbers) {
            int number = Integer.parseInt(stringNumber.trim());
            lotto.addLottoNumber(new LottoNumber(number));
        }
        LottoResult lottoResult = new LottoResult(winningLotto, Collections.singletonList(lotto));

        // then
        assertThat(lottoResult.getResult(key)).isOne();
    }
}
