package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.strategy.TestLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyingLottoGroupTest {

    @Test
    @DisplayName("로또 구매 갯수를 통해 로또를 생성한다.")
    void create(){
        BuyingLottoGroup group = BuyingLottoGroup.create(5, new TestLottoNumberStrategy());

        assertAll(
                () -> assertThat(group.getLottos().size()).isEqualTo(5)
        );
    }

    @Test
    @DisplayName("구매한 로또들을 당첨로또와 비교하여 결과를 반환한다.")
    void getResult(){
        BuyingLottoGroup group = BuyingLottoGroup.create(5, new TestLottoNumberStrategy());
        WinningLotto winning = WinningLotto.create(Lotto.create(Arrays.asList(1,2,3,4,5,7)), LottoNumber.create(6));

        LottoResult result = group.matchWinningLotto(winning);

        assertThat(result.getResultCount(LottoWinningRank.SECOND)).isEqualTo(5);
    }

    @Test
    @DisplayName("방어적 복사 테스트")
    void defensiveCopy(){
        BuyingLottoGroup group = BuyingLottoGroup.create(5, new TestLottoNumberStrategy());
        List<Lotto> lottos = group.getLottos();

        lottos.add(Lotto.create(Arrays.asList(2,3,4,5,6,7)));

        assertThat(group.getLottos().size()).isEqualTo(5);
        assertThat(lottos.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("수동 로또가 있는 경우, 입력받은 수동 로또 정보도 포함한다.")
    void includeManualLotto(){
        BuyingLottoGroup buyingLottoGroup = BuyingLottoGroup.create(5, new TestLottoNumberStrategy(),
                Arrays.asList(
                        Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6))
                ));

        assertThat(buyingLottoGroup.getLottos().size()).isEqualTo(8);
    }
}
