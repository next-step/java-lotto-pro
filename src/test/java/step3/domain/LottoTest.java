package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.utils.NumbersGenerator;

public class LottoTest {

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
            UniqueNumbers numbers = UniqueNumbers.generate(Arrays.asList(1, 2, 3));
            UniqueNumbers random = NumbersGenerator.random();
            Lotto lotto = Lotto.generate(random);
            lotto.getCountOfMatch(numbers);
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Incomparable subject. please check lottoNumbers size.");
    }


    @Test
    @DisplayName("일치하는 번호 개수 확인")
    public void testGetCountOfMatch() {
        UniqueNumbers winner = UniqueNumbers.generate(Arrays.asList(1,2,3,4,5,6));
        UniqueNumbers select = UniqueNumbers.generate(Arrays.asList(4,5,6,7,8,9));
        Lotto lotto = Lotto.generate(select);
        int countOfMatch = lotto.getCountOfMatch(winner);
        assertThat(countOfMatch).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호 포함 확인")
    public void testIsBonusMatch() {
        int bonusNumber = 3;
        UniqueNumbers select = UniqueNumbers.generate(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = Lotto.generate(select);
        assertThat(lotto.isBonusMatch(6)).isTrue();
        assertThat(lotto.isBonusMatch(7)).isFalse();
    }
}
