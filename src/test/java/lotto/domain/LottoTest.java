package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 매치 개수 확인")
    public void lottoTest() {

        Lotto lotto = new Lotto(Arrays.asList(Rank.FIRST, Rank.FIRST, Rank.FIRST));

        assertThat(lotto.getMatchRankCount(Rank.FIRST)).isEqualTo(3);
    }

}
