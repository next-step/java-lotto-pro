package model;

import exception.LottoNumberDuplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoNumbersTest {

    @BeforeEach
    void setUp() {}

    @Test
    @DisplayName("정상적으로 로도 번호를 추가시키는 테스트")
    void add_bonus_ball_success_test() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(new LottoNumbers("1,2,3,4,5,6"));
        winningLottoNumbers.addBonusBall(new LottoNumber("7"));

        assertThat(winningLottoNumbers.equalsBonusBall(new LottoNumber("7"))).isTrue();
    }

    @Test
    @DisplayName("중복된 값을 추가시 에러를 발생시키는 테스트")
    void lotto_number_add_duplication_exception_test() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(new LottoNumbers("1,2,3,4,5,6"));

        assertThatThrownBy(() -> winningLottoNumbers.addBonusBall(new LottoNumber("3")))
                .isInstanceOf(LottoNumberDuplicationException.class);
    }

    @Test
    @DisplayName("매치된 결과값을 반환하는 테스트")
    void winning_lotto_match_test() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(new LottoNumbers("1,2,3,4,5,6"));
        winningLottoNumbers.addBonusBall(new LottoNumber("7"));

        assertThat(winningLottoNumbers.matchExceptBonusBall(new LottoNumbers("1,2,3,4,11,12"))).isEqualTo(4);
    }
}