package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import lotto.strategy.TestLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyingLottoGroupTest {

    @Test
    @DisplayName("로또 구매 갯수를 통해 로또를 생성한다.")
    void create(){
        BuyingLottoGroup group = BuyingLottoGroup.create(5, new TestLottoNumberStrategy());

        assertAll(
                () -> assertThat(group.getLottos().size()).isEqualTo(5),
                () -> assertThat(group.getLottos().get(0)).isEqualTo(Lotto.create(Arrays.asList(1,2,3,4,5,6)))
        );
    }

    @Test
    @DisplayName("구매한 로또들을 당첨로또와 비교하여 결과를 반환한다.")
    void getResult(){
        BuyingLottoGroup group = BuyingLottoGroup.create(5, new TestLottoNumberStrategy());
        WinningLotto winning = WinningLotto.create(Lotto.create(Arrays.asList(1,2,3,4,5,7)), LottoNumber.create(6));

        LottoResult result = group.matchWinningLotto(winning);

        assertThat(result.getResultCount(LottoWinningMoneyEnum.SECOND)).isEqualTo(5);
    }
}
