package lotto.generator;

import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottosGeneratorTest {
    @ParameterizedTest(name="Lottos 구매: Money {0}원 - {1}개 생성")
    @CsvSource(value = {"10000:10", "10500:10"}, delimiter = ':')
    void Lottos_구매_테스트(int money, int count){
        Assertions.assertThat(LottosGenerator.purchaseLottos(new Money(money)).size()).isEqualTo(count);
    }
}