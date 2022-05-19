package lotto.model.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoPaper;
import lotto.model.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorRandomImplTest {

    private LottoGenerator lottoGenerator;

    @DisplayName("랜덤 로또를 생성하며 수동로또와 통합하여 로또 목록을 생성한다.")
    @Test
    void generateLottos() {
        lottoGenerator = new LottoGeneratorRandomImpl();
        List<Lotto> selfLottos = new ArrayList<>();
        selfLottos.add(new Lotto(Arrays.asList(1, 3, 5, 7, 9, 10)));
        selfLottos.add(new Lotto(Arrays.asList(7, 10, 15, 20, 25, 35)));
        selfLottos.add(new Lotto(Arrays.asList(3, 7, 20, 35, 43, 45)));

        Lottos actual = lottoGenerator.generateLottos(new Lottos(selfLottos), new LottoPaper(10, 3));

        assertThat(actual.getLottos()).hasSize(10);
        for (Lotto lotto : selfLottos){
            assertThat(actual.getLottos()).contains(lotto);
        }
    }
}
