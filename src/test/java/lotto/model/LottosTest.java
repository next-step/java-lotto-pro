package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("모든 로또 번호 리스트를 담고 있는 객체를 생성한다.")
    void Lottos_생성() {
        List<LottoNumbers> lottoNumbers = Arrays.asList(
                LottoNumbers.createLottoNumbers(),
                LottoNumbers.createLottoNumbers(),
                LottoNumbers.createLottoNumbers());

        assertThat(Lottos.from(lottoNumbers))
                .isExactlyInstanceOf(Lottos.class)
                .hasFieldOrProperty("lottos")
                .extracting("lottos")
                .isInstanceOf(List.class);
    }
}