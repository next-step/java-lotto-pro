package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    @DisplayName("로또숫자가 6개가 아니면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void validate_count(String inputs) {
        assertThatThrownBy(() -> Lotto.from(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또숫자 중 중복된 숫자가 있으면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "15,16,17,18,19,19"})
    void validate_duplicate(String inputs) {
        assertThatThrownBy(() -> Lotto.from(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또숫자들이 같으면 equals 비교 시 true를 반환한다.")
    @Test
    void equals() {
        assertThat(Lotto.from("1,2,3,4,5,6")).isEqualTo(Lotto.from("1,2,3,4,5,6"));
    }

    @DisplayName("로또간에 로또숫자들을 비교해서 같은 로또숫자의 개수를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:11,12,13,14,15,16:0", "11,12,13,14,15,16:11,12,13,20,21,22:3", "21,22,23,24,25,26:21,22,23,24,25,26:6"}, delimiter = ':')
    void countMatchingNumber(String firstInputs, String secondInputs, int matchCount) {
        Lotto firstLotto = Lotto.from(firstInputs);
        Lotto secondLotto = Lotto.from(secondInputs);

        assertThat(firstLotto.countMatchingNumber(secondLotto)).isEqualTo(matchCount);
    }

    @DisplayName("해당 로또 숫자를 포함하고 있는지 여부를 확인한다.")
    @Test
    void isContainLottoNumber() {
        Lotto lotto = Lotto.from("2,4,6,8,10,12");

        assertAll(
                () -> Assertions.assertThat(lotto.isContainLottoNumber(LottoNumber.from(4))).isTrue(),
                () -> Assertions.assertThat(lotto.isContainLottoNumber(LottoNumber.from(30))).isFalse()
        );
    }

}
