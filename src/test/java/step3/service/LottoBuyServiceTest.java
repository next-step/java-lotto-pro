package step3.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.LottoPayment;
import step3.strategy.AutoLottoNumberStrategy;

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
