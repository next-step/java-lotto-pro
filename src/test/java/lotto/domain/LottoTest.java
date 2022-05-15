package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    private Lotto winLotto;

    @BeforeEach
    void setUp() {
        winLotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("로또의 결과를 맞춰 본다")
    void LottoMatch() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 3, 4, 5, 7, 9)));
        LottoRank lottoRank = lotto.match(winLotto);

        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
        assertThat(lottoRank.rewordMoney()).isEqualTo(LottoRank.THIRD.rewordMoney());
    }


}