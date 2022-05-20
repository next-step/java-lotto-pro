package step3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void beforeEach() {
        lottos = new Lottos(Arrays.asList(
                LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 10)),
                LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 16)),
                LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 15, 16)),
                LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 14, 15, 16)),
                LottoFactory.createManualLotto(Arrays.asList(1, 2, 13, 14, 15, 16))
        ));
    }

    @ParameterizedTest(name = "모든 로또의 당첨내역을 확인한다.")
    @EnumSource(value = Ranking.class, names = {"FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH", "NONE"})
    void 전체_로또_매칭_결과(Ranking ranking) {
        LottoResult lottoResult = lottos.allMatch(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        assertThat(lottoResult.rankingCount(ranking)).isEqualTo(1);
    }
}