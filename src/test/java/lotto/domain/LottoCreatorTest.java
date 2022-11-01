package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCreatorTest {

    @Test
    @DisplayName("Lotto 개수에 맞는 Lotto 개수 생성")
    public void LottoCreator_정상생성() {
        assertThat(LottoCreator.buyLottos(6).size()).isEqualTo(6);
    }

}
