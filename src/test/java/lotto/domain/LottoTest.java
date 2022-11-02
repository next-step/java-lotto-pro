package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static lotto.domain.RandomLottoGenerator.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    @Test
    @DisplayName("LottoNumber 6개로 구성된 로또숫자 세트 생성 작업이 정상적으로 동작한다.")
    public void constructor() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Set<LottoNumber> lottoNumbers = new Lotto(numbers).getLottoNumbers();
        assertThat(lottoNumbers).hasSize(LOTTO_NUMBER_COUNT);
        assertThat(lottoNumbers).containsExactly(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );
    }

    @Test
    @DisplayName("LottoNumber가 6개로 구성되지 않으면 생성 작업 중 예외가 발생한다.")
    public void constructor_fail() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(numbers))
                .withMessageMatching("로또를 생성하기 위해서는 중복되지 않은 숫자 6개가 필요 합니다.");
    }
}
