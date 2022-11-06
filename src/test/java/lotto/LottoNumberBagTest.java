package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

@DisplayName("로또 번호 목록 테스트")
class LottoNumberBagTest {

    private static final String SPLIT_DELIMITER = ",";

    @DisplayName("생성 성공")
    @Test
    void create_bag_success() {
        assertThatNoException().isThrownBy(() -> new LottoNumberBag(new LottoNumberGenerator()));
    }

    @DisplayName("당첨 번호 일치 카운트 제공")
    @Test
    void contains_number_success() {
        //given:
        LottoNumberBag lottoNumberBag = fromManualNumbers("1,2,3,10,20,30");
        WinningLottoBallBag winningNumbers = new WinningLottoBallBag("1,2,3,4,5,6");
        //when:
        Score correctCount = lottoNumberBag.matchScore(winningNumbers);
        //then:
        assertThat(correctCount).isEqualTo(Score.of(3));
    }

    @ParameterizedTest(name = "생성 예외 테스트 - " + DEFAULT_DISPLAY_NAME)
    @ValueSource(strings = { "1,2,3,10,20,30,7", "1,1,3,10,20,30", "1,2,3,10,20,99" })
    void validRange_bag_IllegalArgumentException(String lottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> fromManualNumbers(lottoNumbers));
    }

    @DisplayName("수동 번호 생성 성공")
    @Test
    void fromManualNumbers_lottoNumberBag_success() {
        //given:
        String input = "1,2,3,4,5,6";
        //when, then:
        assertThatNoException().isThrownBy(() -> fromManualNumbers(input));
    }

    static LottoNumberBag fromManualNumbers(String input) {
        return new LottoNumberBag(Arrays.stream(input.split(SPLIT_DELIMITER))
                .map(it -> new LottoNumber(it.trim()))
                .collect(Collectors.toList()));
    }
}
