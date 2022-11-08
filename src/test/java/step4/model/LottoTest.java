package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또_결과값_저장_클래스")
public class LottoTest {
    @DisplayName("Lotto_정상_입력")
    @Test
    void Lotto_pass_01() {
        assertThatNoException().isThrownBy(() -> new Lotto(
                Arrays.asList(
                        LottoNumber.valueOf("1"), LottoNumber.valueOf("2"), LottoNumber.valueOf("3"),
                        LottoNumber.valueOf("4"), LottoNumber.valueOf("5"), LottoNumber.valueOf("6")
                )
        ));
    }

    @DisplayName("문자열_배열이_입력되면_각각_객체가_생성된다")
    @Test
    void Lotto_pass_02() {
        String[] inputNumberTexts = new String[]{"1", "2", "3", "4", "5", "6"};
        Lotto numbers = new Lotto(inputNumberTexts);
        assertThat(numbers).isEqualTo(new Lotto(
                        Arrays.asList(
                                LottoNumber.valueOf("1"), LottoNumber.valueOf("2"), LottoNumber.valueOf("3"),
                                LottoNumber.valueOf("4"), LottoNumber.valueOf("5"), LottoNumber.valueOf("6")
                        )
                )
        );
    }

    @DisplayName("Lotto_간_같은_값_크기를_반환한다.")
    @Test
    void Lotto_pass_03() {
        String[] inputNumberTexts = new String[]{"1", "2", "3", "4", "5", "6"};
        String[] inputOtherNumberTexts = new String[]{"4", "5", "6", "7", "8", "9"};
        Lotto lotto = new Lotto(inputNumberTexts);
        Lotto otherLotto = new Lotto(inputOtherNumberTexts);
        assertThat(lotto.getEqualCount(otherLotto)).isEqualTo(3);
    }

    @DisplayName("Lotto_정렬_성공.")
    @Test
    void Lotto_pass_04() {
        String[] inputNumberTexts = new String[]{"6", "4", "5", "3", "2", "1"};
        String[] inputOtherNumberTexts = new String[]{"1", "2", "3", "4", "5", "6"};
        Lotto lotto = new Lotto(inputNumberTexts);
        Lotto otherLotto = new Lotto(inputOtherNumberTexts);
        assertThat(lotto).isEqualTo(otherLotto);
    }

    @DisplayName("Lotto_contains_성공.")
    @Test
    void Lotto_pass_05() {
        String[] inputNumberTexts = new String[]{"6", "4", "5", "3", "2", "1"};
        Lotto lotto = new Lotto(inputNumberTexts);
        assertThat(lotto.isContains(LottoNumber.valueOf(6))).isTrue();
    }

    @DisplayName("Lotto_중복값_들어오면_에러를_반환한다.")
    @Test
    void Lotto_fail_01() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,5")).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("Lotto_크기가_넘어가는_값이_들어오면_에러를_반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "3"})
    void Lotto_fail_02(String lottoNumbersTest) {
        assertThatThrownBy(() -> new Lotto(lottoNumbersTest.split("\\s*,\\s*"))).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("빈값이_입력되면_에러를_반환_한다")
    @Test
    void Lotto_fail_03() {
        String[] inputNumberTexts = new String[]{};
        assertThatThrownBy(() -> new Lotto(inputNumberTexts))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto_contains_실패.")
    @Test
    void Lotto_fail_04() {
        String[] inputNumberTexts = new String[]{"6", "4", "5", "3", "2", "1"};
        Lotto lotto = new Lotto(inputNumberTexts);
        assertThat(lotto.isContains(LottoNumber.valueOf(7))).isFalse();
    }

}