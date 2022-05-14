package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumbersTest {

    @DisplayName("1부터45까지 숫자를 가지고 있다.")
    @Test
    void createTest() {
        assertThat(new LottoNumbers()).isEqualTo(new LottoNumbers(default45LottoNumbers()));
    }

    @DisplayName("섞는 방법은 입력받아서 로또숫자를 추출한다.")
    @Test
    void extractTest() {
        assertThat(new LottoNumbers().extract((lottoNumbers) -> {
        }))
                .isEqualTo(LottoTest.createLottoNumberList(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @DisplayName("추출된 로또번호는 수정이 불가능하다")
    @Test
    void immutableTest() {
        List<LottoNumber> extract = new LottoNumbers().extract((lottoNumbers) -> {});
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> extract.add(new LottoNumber(2)));

        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> extract.remove(0));
    }

    private List<LottoNumber> default45LottoNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }
}
