package step3.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 테스트")
class LottoTests {

    @Test
    @DisplayName("중복되지 않은 로또 번호가 6개일 경우 로또가 생성된다")
    void should_Create() {
        List<LottoNumber> lottoNumbers = createLottoNumbers(6);

        assertThatCode(() -> new Lotto(lottoNumbers))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호가 6개 미만이면 예외가 발생한다")
    void should_IllegalArgumentException_When_LottoNumbers6Less() {
        assertThatThrownBy(() -> new Lotto(createLottoNumbers(0)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 번호는 6개여야 합니다. (lottoNumbers: 0)");
    }

    @Test
    @DisplayName("로또 번호가 6개를 초과하면 예외가 발생한다")
    void should_IllegalArgumebntException_When_LottoNumbers6Over() {
        List<LottoNumber> lottoNumbers = createLottoNumbers(7);

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 번호는 6개여야 합니다. (lottoNumbers: 7)");
    }

    @Test
    @DisplayName("로또 번호가 중복되면 예외가 발생한다")
    void should_IllegalArgumebntException_When_LottoNumbersDuplicate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(6));
        lottoNumbers.add(new LottoNumber(6));

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 번호는 중복될 수 없습니다. (lottoNumbers: [1, 2, 3, 4, 6, 6])");
    }

    private List<LottoNumber> createLottoNumbers(int count) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(new LottoNumber(i + 1));
        }
        return lottoNumbers;
    }
}
