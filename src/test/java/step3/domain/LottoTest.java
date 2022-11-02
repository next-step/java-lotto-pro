package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step3.domain.Lotto.LOTTO_NUMBERS_SIZE;

/* TODO : https://learn.microsoft.com/ko-kr/dotnet/core/testing/unit-testing-best-practices
     if, for 키워드를 사용하는 구문은 로직이다
     따라서 테스트 코드 내에 로직이 있으므로, 로직을 검증하기 위한 테스트 코드가 별도로 필요하다.
     반복적인 검증이 필요하다면, for문이 아닌 반복 테스트나 다이내믹 테스트를 이용하는 방식으로 구현
     테스트 코드 밖에서 테스트 픽스쳐 등을 통해 주입해주는 방식으로..
 */
public class LottoTest {

    @DisplayName("로또는 로또번호 6개로 구성된다")
    @Test
    void 로또생성() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBERS_SIZE; i++) {
            lottoNumbers.add(LottoCreateStrategy.lottoNumberMap.get(i + 1));
        }
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @DisplayName("로또는 로또번호 6개가 아닌경우는 예외")
    @Test
    void 로또생성시_6개가_아닌경우_예외() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBERS_SIZE + 2; i++) {
            lottoNumbers.add(LottoCreateStrategy.lottoNumberMap.get(i + 1));
        }

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호에 대한 중복체크")
    @Test
    void 로또생성시_중복체크_예외() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        int limit = LOTTO_NUMBERS_SIZE - 1;
        for (int i = 0; i < limit; i++) {
            lottoNumbers.add(LottoCreateStrategy.lottoNumberMap.get(i + 1));
        }
        lottoNumbers.add(LottoCreateStrategy.lottoNumberMap.get(limit - 1));

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 동일성 테스트")
    @Test
    void 로또_equal_검증() {
        List<LottoNumber> lottoNumbersCompare1 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbersCompare1.add(LottoCreateStrategy.lottoNumberMap.get(i + 1));
        }

        List<LottoNumber> lottoNumbersCompare2 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbersCompare2.add(LottoCreateStrategy.lottoNumberMap.get(i + 1));
        }

        Lotto lotto1 = new Lotto(lottoNumbersCompare1);
        Lotto lotto2 = new Lotto(lottoNumbersCompare2);

        assertThat(lotto1.equals(lotto2)).isTrue();
    }
}
