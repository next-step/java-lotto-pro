package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoPurchaseMachineTest {

    @Test
    void generateLottoNumbers_로또_자동생성() {
        AutoLottoPurchaseMachine autoLottoPurchaseMachine = new AutoLottoPurchaseMachine();
        List<Integer> lottoList = autoLottoPurchaseMachine.generateLottoNumbers();
        assertThat(lottoList.size()).isEqualTo(6);
    }
}
