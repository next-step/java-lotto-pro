package lottoauto.service;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lottoauto.domain.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoResultServiceTest {

    LottoResultService lottoResultService;

    @BeforeEach
    void beforeEach(){
        LottoResult result = new LottoResult();
        result.addLottoResult(3, Lotto.create(Arrays.asList(1,2,3,4,5,6)));
        result.addLottoResult(3, Lotto.create(Arrays.asList(1,2,3,4,5,6)));
        result.addLottoResult(4, Lotto.create(Arrays.asList(1,2,3,4,5,6)));
        result.addLottoResult(5, Lotto.create(Arrays.asList(1,2,3,4,5,6)));

        lottoResultService = new LottoResultService(result);
    }

    @Test
    @DisplayName("로또 당첨금을 계산한다.")
    void 당첨금_계산(){
        assertThat(lottoResultService.calculateWinningMoney()).isEqualTo(1560000);
    }

    @Test
    @DisplayName("당첨금에 대한 수익률을 계산한다.")
    void 수익률_계산(){
        assertThat(lottoResultService.calculateReturnRate(1000)).isEqualTo(new LottoReturnRate(new BigDecimal(String.valueOf(1.56))));
    }
}
