package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

class LottoControllerTest {
    private static LottoController lottoController;

    @BeforeAll
    static void beforeAll() {
        lottoController = LottoController.getInstance();
    }

    @Test
    @DisplayName("입력 금액 로또 구입 수 테스트")
    void buy_Lotto_count_test() {
        assertThat(lottoController.buyLotto(5000L)).isEqualTo(5);
    }

    @Test
    @DisplayName("당첨 금액 환전 테스트")
    void exchange_prize_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9)));
        assertThat(lottoController.exchangePrize(Collections.singletonList(lotto), lotto)).isEqualTo(2000000000L);
    }

}