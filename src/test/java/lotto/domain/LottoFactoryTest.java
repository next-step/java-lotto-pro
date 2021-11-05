package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    void 로또_발급() {
        // given, when
        LottoNumbers lottoNumbers = LottoFactory.createLottoNumbers();

        // then
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    void 발급된_로또_중복_체크() {
        // given
        LottoNumbers lottoNumbers = LottoFactory.createLottoNumbers();

        // when
        boolean result = containsDuplicateNumber(lottoNumbers);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 발급된_로또_오름차순_정렬() {
        // given
        LottoNumbers lottoNumbers = LottoFactory.createLottoNumbers();

        // when
        boolean result = validateAscending(lottoNumbers);

        // then
        assertThat(result).isTrue();
    }

    private boolean containsDuplicateNumber(LottoNumbers lottoNumbers) {
        Set<LottoNumber> set = new HashSet<>();
        for (int i = 0; i < lottoNumbers.getLottoNumbers().size(); i++) {
            if (set.contains(lottoNumbers.getLottoNumbers().get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean validateAscending(LottoNumbers lottoNumbers) {
        List<LottoNumber> list = lottoNumbers.getLottoNumbers();
        for (int i = 0; i < lottoNumbers.getLottoNumbers().size() - 1; i++) {
            if (list.get(i).getNumber() >= list.get(i + 1).getNumber()) {
                return false;
            }
        }
        return true;
    }
}
