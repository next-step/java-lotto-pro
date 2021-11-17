package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AutoLottoPurchaseMachineTest {

    @Test
    void generateLottoNumbers_입력한_수만큼_로또_자동생성() {
        AutoLottoPurchaseMachine autoLottoPurchaseMachine = new AutoLottoPurchaseMachine();
        List<Lotto> expected = autoLottoPurchaseMachine.generateLottoNumbers(10);
        assertAll(
                () -> assertThat(expected).isNotNull(),
                () ->  assertThat(expected).hasSize(10),
                () ->  assertThat(expected.get(0).getLottoNumbers()).hasSize(6)
        );
    }
}
