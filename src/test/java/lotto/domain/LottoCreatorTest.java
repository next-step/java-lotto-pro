package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoCreatorTest {

    @Test
    @DisplayName("6개의 로또숫자가 List에 있는지 확인")
    void makeLotto() {
        LottoCreator lottoCreator = new LottoCreator();
        List<Integer> lottos = lottoCreator.makeLotto();
        assertThat(lottos.size()).isEqualTo(6);
    }
}
