package lotto.domain;

import lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 번호 컬렉션 테스트")
class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호 컬렉션 생성")
    void createLottoNumbersTest() {
        Set<LottoNumber> lottoNumberSet = Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberSet);
        assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐 시에 InvalidLottoNumberException 발생")
    void throwInvalidLottoNumbersCountTest() {
        Set<LottoNumber> lottoNumberSet = Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );
        assertThatThrownBy(() -> LottoNumbers.of(lottoNumberSet))
                .isInstanceOf(InvalidLottoNumberException.class);
    }

    @Test
    @DisplayName("같은 로또 번호 컬렉션인지 확인")
    void equalsTest() {
        Set<LottoNumber> lottoNumberSet = Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberSet);
        assertThat(lottoNumbers).isEqualTo(LottoNumbers.of(lottoNumberSet));
    }

}