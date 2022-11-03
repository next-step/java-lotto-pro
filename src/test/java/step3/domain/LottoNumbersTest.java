package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {
    @Test
    void LottoNumber_Set_을_이용한_생성() {
        Set<LottoNumber> lottoNumberSet = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
        assertThatCode(() -> new LottoNumbers(lottoNumberSet)).doesNotThrowAnyException();
    }

    @Test
    void 동등성_비교() {
        String lottoNumberAsString = "1, 2, 3, 4, 5, 6";
        assertThat(new LottoNumbers(lottoNumberAsString)).isEqualTo(new LottoNumbers(lottoNumberAsString));
    }

    @Test
    void LottoNumber_Set_의_크기가_6이_아닌경우_생성불가() {
        Set<LottoNumber> lottoNumberSet = Stream.of(1, 2, 3, 4, 5, 5)
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
        assertThatCode(() -> new LottoNumbers(lottoNumberSet))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복되지 않은 숫자 6자리로 이루어져야 합니다.");
    }

    @Test
    void LottoNumber_String_을_이용한_생성() {
        String lottoNumbers = "1, 2, 3, 4, 5, 6";
        assertThatCode(() -> new LottoNumbers(lottoNumbers)).doesNotThrowAnyException();
    }

    @Test
    void LottoNumber_String_의_구분자가_쉼표가_아닐경우_생성불가() {
        String lottoNumbers = "1 : 2 : 3 : 4 : 5 : 6";
        assertThatCode(() -> new LottoNumbers(lottoNumbers)).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void LottoNumber_String_내_중복된_숫자가_있는경우_생성불가() {
        String lottoNumbers = "1, 2, 3, 4, 5, 5";
        assertThatCode(() -> new LottoNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복되지 않은 숫자 6자리로 이루어져야 합니다.");
    }

    @Test
    void LottoNumber_String_내_중복되지_않는_숫자가_6개가_아닐경우_생성불가() {
        String lottoNumbers = "1, 2, 3, 4, 5";
        assertThatCode(() -> new LottoNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복되지 않은 숫자 6자리로 이루어져야 합니다.");
    }

    @Test
    void 다른_LottoNumbers_와_비교해_숫자가_일치하는_개수를_찾을_수_있다() {
        LottoNumbers myPickedNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        LottoNumbers winningNumbers = new LottoNumbers("1, 2, 3, 4, 5, 7");
        assertThat(myPickedNumbers.compareTo(winningNumbers)).isEqualTo(5);
    }

    @Test
    void toString_호출시_로또_번호_목록을_출력한다() {
        LottoNumbers lottoNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        String expectedPrintResult = "[1, 2, 3, 4, 5, 6]";
        assertThat(lottoNumbers.toString()).isEqualTo(expectedPrintResult);
    }

    @Test
    void 로또_번호의_포함_여부를_확인할_수_있다() {
        LottoNumbers lottoNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = LottoNumber.from(6);
        assertThat(lottoNumbers.contains(bonusNumber)).isTrue();
    }
}
