package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 구입 개수만큼 반환 확인")
    public void validCount() {
        Lottos lottos = new Lottos(14);
        assertThat(lottos.allGames().size()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 구입시 수동 개수만큼 포함하여 반환 확인")
    public void validWithManualCount() {
        Lottos lottos = new Lottos(14);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lottoList.add(new Lotto(1,2,3,4,5,6));
        }
        lottos.merge(new Lottos(lottoList));
        assertThat(lottos.allGames().size()).isEqualTo(17);
    }

}
