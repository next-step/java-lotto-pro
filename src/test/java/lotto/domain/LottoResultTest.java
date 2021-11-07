package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 결과 테스트")
    @ParameterizedTest(name = "{displayName} -> input: {0}, key: {1}")
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
        int[] numbers = Arrays.stream(stringNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();
        Lotto lotto = new Lotto(numbers);
        LottoResult lottoResult = new LottoResult(winningLotto, Collections.singletonList(lotto));

        // then
        assertThat(lottoResult.getResult(key)).isOne();
    }

    @DisplayName("로또 수익률 테스트")
    @Test
    void earningsRate() {
        // given
        List<Lotto> lottoList = new ArrayList<Lotto>() {
            {
                add(new Lotto(8, 21, 23, 41, 42, 43));
                add(new Lotto(3, 5, 11, 16, 32, 38));
                add(new Lotto(7, 11, 16, 35, 36, 44));
                add(new Lotto(1, 8, 11, 31, 41, 42));
                add(new Lotto(13, 14, 16, 38, 42, 45));
                add(new Lotto(7, 11, 30, 40, 42, 43));
                add(new Lotto(2, 13, 22, 32, 38, 45));
                add(new Lotto(23, 25, 33, 36, 39, 41));
                add(new Lotto(1, 3, 5, 14, 22, 45));
                add(new Lotto(5, 9, 38, 41, 43, 44));
                add(new Lotto(2, 8, 9, 18, 19, 21));
                add(new Lotto(13, 14, 18, 21, 23, 35));
                add(new Lotto(17, 21, 29, 37, 42, 45));
                add(new Lotto(3, 8, 27, 30, 35, 44));
            }
        };

        // when
        LottoResult lottoResult = new LottoResult(winningLotto, lottoList);

        // then
        Assertions.assertThat(lottoResult.getEarningsRate()).isEqualTo(0.35);
    }
}
