package lotto.domain;

import lotto.domain.LottoNumber;
import lotto.domain.LottoProperty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("로또 번호는 6개")
    @Test
    void lottoNumberSixTest() {
        List<Integer> lottoNumbers = LottoNumber.generator();

        assertThat(lottoNumbers.size()).isEqualTo(LottoProperty.LOTTO_COUNT);
    }

    @DisplayName("로또 번호는 중복 불가")
    @Test
    void nonDuplicateLottoNumberTest() {
        List<Integer> lottoNumbers = LottoNumber.generator();

        HashSet<Integer> nonDuplicateLottoNumber = new HashSet<>(lottoNumbers);

        assertThat(nonDuplicateLottoNumber.size()).isEqualTo(lottoNumbers.size());
    }

    @DisplayName("로또 번호는 오름차순 정렬")
    @Test
    void lottoNumberAscSortTest() {
        List<Integer> lottoNumbers = LottoNumber.generator();

        assertThat(lottoNumbers).isSorted();
    }

    @DisplayName("로또 번호는 1부터 45 사이")
    @Test
    void lottoNumberRangeTest() {
        List<Integer> lottoNumbers = LottoNumber.generator();

        boolean lottoNumberRange = lottoNumbers.stream()
                .allMatch(number -> number >= LottoProperty.LOTTO_START_NUMBER && number <= LottoProperty.LOTTO_END_NUMBER);

        assertThat(lottoNumberRange).isTrue();
    }
}
