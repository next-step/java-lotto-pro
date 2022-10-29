package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {
    @DisplayName("LottoResult_정상_입력")
    @Test
    void LottoResult_pass_01() {
        assertThatNoException().isThrownBy(() -> new LottoResult(
                Arrays.asList(
                        new LottoNumber("1"), new LottoNumber("2"), new LottoNumber("3"),
                        new LottoNumber("4"), new LottoNumber("5"), new LottoNumber("6")
                )
        ));
    }

    @DisplayName("문자열_배열이_입력되면_각각_객체가_생성된다")
    @Test
    void LottoResult_pass_02() {
        String[] inputNumberTexts = new String[]{"1", "2", "3", "4", "5", "6"};
        LottoResult numbers = new LottoResult(inputNumberTexts);
        assertThat(numbers).isEqualTo(new LottoResult(
                        Arrays.asList(
                                new LottoNumber("1"), new LottoNumber("2"), new LottoNumber("3"),
                                new LottoNumber("4"), new LottoNumber("5"), new LottoNumber("6")
                        )
                )
        );
    }

    @DisplayName("LottoResult_간_같은_값_크기를_반환한다.")
    @Test
    void LottoResult_pass_03() {
        String[] inputNumberTexts = new String[]{"1", "2", "3", "4", "5", "6"};
        String[] inputOtherNumberTexts = new String[]{"4", "5", "6", "7", "8", "9"};
        LottoResult lottoResult = new LottoResult(inputNumberTexts);
        LottoResult otherLottoResult = new LottoResult(inputOtherNumberTexts);
        assertThat(lottoResult.getEqualCount(otherLottoResult)).isEqualTo(3);
    }

    @DisplayName("LottoResult_정렬_성공.")
    @Test
    void LottoResult_pass_04() {
        String[] inputNumberTexts = new String[]{"6", "4", "5", "3", "2", "1"};
        String[] inputOtherNumberTexts = new String[]{"1", "2", "3", "4", "5", "6"};
        LottoResult lottoResult = new LottoResult(inputNumberTexts);
        LottoResult otherLottoResult = new LottoResult(inputOtherNumberTexts);
        assertThat(lottoResult).isEqualTo(otherLottoResult);
    }

    @DisplayName("LottoResult_중복값_들어오면_에러를_반환한다.")
    @Test
    void LottoResult_fail_01() {
        assertThatThrownBy(() -> new LottoResult(
                Arrays.asList(
                        new LottoNumber("1"), new LottoNumber("3"), new LottoNumber("3"),
                        new LottoNumber("4"), new LottoNumber("5"), new LottoNumber("6")
                )
        )).isInstanceOf(RuntimeException.class);
    }


    @DisplayName("LottoResult_크기가_넘어가는_값이_들어오면_에러를_반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "3"})
    void LottoResult_fail_02(String lottoNumbersTest) {
        assertThatThrownBy(() -> new LottoResult(lottoNumbersTest.split("\\s*,\\s*"))).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("빈값이_입력되면_에러를_반환_한다")
    @Test
    void LottoResult_fail_03() {
        String[] inputNumberTexts = new String[]{};
        assertThatThrownBy(() -> new LottoResult(inputNumberTexts))
                .isInstanceOf(RuntimeException.class);
    }
}
