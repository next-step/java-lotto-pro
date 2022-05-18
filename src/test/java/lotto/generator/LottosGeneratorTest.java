package lotto.generator;

import lotto.domain.Lotto;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottosGeneratorTest {
    @ParameterizedTest(name="Lottos 자동 구매: Money {0}원 - {1}개 생성")
    @CsvSource(value = {"10000:10", "10500:10"}, delimiter = ':')
    void Lottos_구매_테스트(int money, int count){
        assertThat(LottosGenerator.purchaseAutoLottos(new Money(money)).size()).isEqualTo(count);
    }

    @Test
    @DisplayName("Lottos 수동 구매")
    void Lottos_수동_구매_테스트(){
        List<Lotto> manualLottos = new ArrayList<>(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));
        assertThat(LottosGenerator.purchaseManualLottos(manualLottos).size()).isEqualTo(1);
    }

    @ParameterizedTest(name="Lottos 수동 자동 조합 구매: Money {0}원 - {1}개 생성")
    @CsvSource(value = {"10000:10", "10500:10"}, delimiter = ':')
    void Lottos_수동_자동_구매_테스트(int money, int count){
        assertThat(
                LottosGenerator.purchaseManualAndAutoLottos(
                        new Money(money),
                        new ArrayList<>(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
                ).size()
        ).isEqualTo(count);
    }
}