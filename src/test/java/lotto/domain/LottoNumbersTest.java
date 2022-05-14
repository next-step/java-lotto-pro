package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {
    @DisplayName("로또 번호의 목록을 가진 LottoNumbers 생성")
    @Test
    void test_로또_번호_목록_생성() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        //then
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(numbers));
    }

    @DisplayName("로또 번호가 비어있는 경우 예외 처리")
    @Test
    void test_로또_번호가_비어있는_경우() {
        //given
        List<Integer> numbers = Collections.emptyList();
        //when & then
        assertThatThrownBy(() -> new LottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_EMPTY_LOTTO);
    }

    @DisplayName("로또 1장에 번호 6개가 아닌 경우 예외 처리")
    @Test
    void test_로또_1장에_번호_6개가_아닌_경우() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //when & then
        assertThatThrownBy(() -> new LottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_SIZE_LOTTO);
    }

    @DisplayName("로또 1장에 중복된 번호가 포함된 경우 예외 처리")
    @Test
    void test_로또_1장에_중복된_번호가_포함된_경우() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        //when & then
        assertThatThrownBy(() -> new LottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_NUMBER);
    }

    @DisplayName("당첨 번호와 구매 번호의 매칭 개수 확인")
    @Test
    void test_당첨_번호와_매칭_개수() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumbers winningNumbers = new LottoNumbers(numbers);
        //then
        assertThat(lottoNumbers.matchCount(winningNumbers)).isEqualTo(6);
    }

    @DisplayName("당첨 순위 확인")
    @Test
    void test_당첨_순위() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumbers winningNumbers = new LottoNumbers(numbers);
        //then
        assertThat(lottoNumbers.rank(winningNumbers)).isEqualTo(Rank.FIRST);
    }
}