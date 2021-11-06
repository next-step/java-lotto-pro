package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoPurchaseTest {

    @Test
    void generateLottoNumbers_로또_자동생성() {
        AutoLottoPurchase autoLottoPurchase = new AutoLottoPurchase();
        List<Integer> lottoList = autoLottoPurchase.generateLottoNumbers();
        assertThat(lottoList.size()).isEqualTo(6);
    }
}
