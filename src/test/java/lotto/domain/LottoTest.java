package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @Test
    void 로또_생성_성공() {
        List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto).isNotNull();
    }

    @Test
    void 로또_생성_실패() {
        List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5));

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(numbers)
        ).withMessageContaining("로또 번호는 6개여야 합니다.");
    }

}
