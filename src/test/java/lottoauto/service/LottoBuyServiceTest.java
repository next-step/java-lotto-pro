package lottoauto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lottoauto.domain.Lotto;
import lottoauto.domain.LottoPayment;
import lottoauto.strategy.AutoLottoNumberStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoBuyServiceTest {

    LottoBuyService lottoBuyService;

    @Test
    @DisplayName("로또 구입금액에 따라 로또를 생성한다.")
    void 로또_구입_생성(){
        lottoBuyService = new LottoBuyService(new LottoPayment("10000"), new AutoLottoNumberStrategy());
        List<Lotto> lottos = lottoBuyService.generateLottos();

        assertThat(lottos.size()).isEqualTo(lottoBuyService.getCount());
    }

}
