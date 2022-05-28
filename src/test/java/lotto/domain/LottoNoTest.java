package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNoTest {

    @Test
    @DisplayName("로또번호 1~45 이외 값 유효성 검사")
    void numberRangeFail() {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoNo(46)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNo(0)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또번호 문자열 입력시 1~45 유효성 검사")
    void stringNumberRangeFail() {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoNo("0")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNo("46")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또번호 문자열 입력시 숫자 이외 값 검사")
    void stringInputFail() {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoNo("1I")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNo("45I")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("당첨번호와 보너스볼 중복 확인")
    void validateBonus() {
        LottoNo bonusBall = new LottoNo(6);
        assertThatThrownBy(
                () -> bonusBall.validateBonus(new Lotto(new String[]{"1", "2", "3", "4", "5", "6"}))).isInstanceOf(
                IllegalArgumentException.class);
    }
}