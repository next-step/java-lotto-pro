package lottoauto.service;

import lottoauto.strategy.AutoLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lottoauto.domain.Lotto;
import lottoauto.domain.LottoResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {

    LottoService lottoService;

    @Test
    @DisplayName("당첨로또에 대한 구매로또의 결과를 확인한다.")
    void 당첨_구매_결과(){
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.create(Arrays.asList(2, 3, 4, 5, 6, 7)));
        lottos.add(Lotto.create(Arrays.asList(5, 6, 7, 8, 9, 11)));
        lottos.add(Lotto.create(Arrays.asList(9, 11, 15, 16, 17, 18)));

        Lotto winning = Lotto.create(Arrays.asList(2, 3, 5, 8, 9, 11));

        lottoService = new LottoService(new AutoLottoNumberStrategy());
        LottoResult result = lottoService.matched(lottos, winning);

        assertThat(result.getResultCount(3)).isEqualTo(2);
        assertThat(result.getResultCount(4)).isEqualTo(1);
    }
}
