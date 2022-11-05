package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LottoUtil;
import step3.domain.Lottos;
import step3.domain.Money;

public class LottoUtilTest {

    private final LottoUtil lottoUtil = new LottoUtil();

    @Test
    @DisplayName("금액을 입력해서 자동으로 로또를 구매하는 테스트")
    void 보유한_금액만큼_로또를_자동으로_구매할_수_있다() {
        Money money = new Money(5000);
        int lottos = lottoUtil.buy(money);
        assertThat(lottos).isEqualTo(5);
    }

    @Test
    @DisplayName("수동으로 입력한 숫자를 로또로 바꿔주는 기능 테스트")
    void nubersToLotto() {
        List<String> manualLottoNumbers = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7");
        Lottos lottos = lottoUtil.buy(manualLottoNumbers);
        assertThat(lottos.getHasLottoSize()).isEqualTo(2);
    }
}
