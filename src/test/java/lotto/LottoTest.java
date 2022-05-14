package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_생성_테스트() {
        // when & then
        assertThat(Lotto.auto()).isNotNull();

    }

}