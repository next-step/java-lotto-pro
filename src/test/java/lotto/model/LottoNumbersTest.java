package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.constants.LottoConstant.LOTTO_PICK_COUNT;
import static lotto.model.LottoNumbers.createWinningNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 숫자 리스트를 정상적으로 생성하는지 확인한다.")
    void createLottoNumbers_로또숫자_리스트() {
        assertThat(LottoNumbers.createLottoNumbers())
                .isExactlyInstanceOf(LottoNumbers.class)
                .hasFieldOrProperty("lottoNumbers")
                .extracting("lottoNumbers")
                .isInstanceOf(List.class);
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 개수를 카운트 한다.")
    void matchCount_일치_카운트() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(10, 4, 1, 33, 23, 45));
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 3, 19, 25, 33, 45));

        assertThat(lottoNumbers.matchCount(winningNumbers))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("입력 값에 중복 번호가 존재하면 예외를 발생시킨다.")
    void createWinningNumbers_중복예외() {
        List<Integer> numbers = Arrays.asList(10, 4, 1, 23, 23, 45);

        assertThatThrownBy(() -> createWinningNumbers(numbers))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에 중복 값이 존재합니다!");
    }

    @Test
    @DisplayName("입력 값이 사이즈를 초과하면 예외를 발생시킨다.")
    void createWinningNumbers_사이즈예외() {
        List<Integer> numbers = Arrays.asList(10, 4, 1, 23, 23, 45, 2);

        assertThatThrownBy(() -> createWinningNumbers(numbers))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 %d개 입력해 주세요!", LOTTO_PICK_COUNT);
    }

    @Test
    @DisplayName("로또 번호 생성을 확인한다.")
    void createWinningNumbers_생성() {
        List<Integer> numbers = Arrays.asList(10, 4, 1, 23, 25, 45);
        LottoNumbers winningNumbers = createWinningNumbers(numbers);

        assertThat(winningNumbers.size())
                .isEqualTo(LOTTO_PICK_COUNT);
        assertThat(winningNumbers.toString())
                .isEqualTo("[10, 4, 1, 23, 25, 45]");
    }

}
