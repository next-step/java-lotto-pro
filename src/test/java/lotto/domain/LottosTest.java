package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    @Test
    @DisplayName("Lottos에 랜덤 Lotto 추가 테스트")
    void Lottos_랜덤로또_추가_테스트(){
        Lottos lottos = new Lottos();
        lottos.addRandomLotto();
        assertThat(lottos.size()).isEqualTo(1);
    }
}
