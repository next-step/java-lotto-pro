package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 생성 개수 테스트")
    void generate_lottos_cnt_test() {
        assertThat(new Lottos(new Payment("14000").getPurchasedLottoCnt()).getLottosSize()).isEqualTo(14);
    }

}
