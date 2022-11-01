package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.utils.NumbersGenerator;

public class LottoTest extends AbstractTest {

    @Test
    @DisplayName("로또 생성")
    public void testGenerate() {
        UniqueNumbers random = NumbersGenerator.random();
        Lotto lotto = Lotto.generate(random);
        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("번호 비교시 대상 개수가 다른 경우 Exception 발생")
    public void testNumberSizeError() {
        assertThatThrownBy(() -> {
            Lotto lotto = Lotto.generate(randomNumbers);
            lotto.getCountOfMatch(exceptNumbers);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Incomparable subject. please check lottoNumbers size.");
    }

    @Test
    @DisplayName("일치하는 번호 개수 확인")
    public void testGetCountOfMatch() {
        Lotto lotto = Lotto.generate(start4Numbers);
        int countOfMatch = lotto.getCountOfMatch(start1Numbers);
        assertThat(countOfMatch).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호 포함 확인")
    public void testIsBonusMatch() {
        int bonusNumber = 3;
        Lotto lotto = Lotto.generate(start1Numbers);
        assertThat(lotto.isBonusMatch(new Number(6))).isTrue();
        assertThat(lotto.isBonusMatch(new Number(7))).isFalse();
    }
}
