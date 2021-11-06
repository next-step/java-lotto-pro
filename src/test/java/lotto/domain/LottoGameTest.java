package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    void test() {
        LottoGame lottoGame = new LottoGame(
                Arrays.asList(
                        new LottoBalls("1,2,3,4,5,6"),
                        new LottoBalls("7,8,9,10,11,12"),
                        new LottoBalls("13,14,15,16,17,18")
                )
        );

        String result = lottoGame.toString();

        assertThat(result).isEqualTo(
                "[1,2,3,4,5,6]\n[7,8,9,10,11,12]\n[13,14,15,16,17,18]\n"
        );
    }
}