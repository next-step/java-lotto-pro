package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoCreateServiceTest {
    private final static int LOTTO_SIZE = 6;

    @DisplayName("로또를 자동생성하는 기능 검증")
    @Test
    void lottoCreate() {
        LottoAutoCreateService lottoAutoCreateService = new LottoAutoCreateService();
        Lotto lotto = lottoAutoCreateService.createLotto();
        assertThat(lotto.size()).isEqualTo(LOTTO_SIZE);
    }

}
