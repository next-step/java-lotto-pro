package lotto.domain;

import lotto.constant.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Lotto 테스트")
class LottoTest {
    @Test
    @DisplayName("정상 생성 확인")
    void 정상_생성_확인() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when, then
        assertThat(new Lotto(numbers)).isEqualTo(new Lotto(numbers));
    }

    @Test
    @DisplayName("중복 숫자 에러")
    void 중복_숫자_에러() {
        // given
        List<Integer> numbers = Arrays.asList(1, 1, 2, 2, 3, 3);

        // when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(numbers));
    }

    @Test
    @DisplayName("번호 갯수 불일치")
    void 번호_갯수_불일치() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(numbers));
    }

    @Test
    @DisplayName("상태 출력 확인")
    void 상태_출력_확인() {
        // given
        List<Integer> numbers = Arrays.asList(6, 5, 4, 3, 2, 1);
        Lotto lotto = new Lotto(numbers);

        // when
        List<String> lottoStatus = lotto.getStatus();

        assertThat(lottoStatus)
                .isEqualTo(Arrays.asList("1", "2", "3", "4", "5", "6"));
    }

    @Test
    @DisplayName("로또 결과 확인")
    void 로또_결과_확인() {
        // given
        List<Integer> numbers = Arrays.asList(6, 5, 4, 3, 2, 1);
        Lotto lotto = new Lotto(numbers);
        Lotto winningLotto = new Lotto(numbers);

        // when
        LottoRank lottoRank = winningLotto.checkMatchRank(lotto);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.FIRST);
    }
}
