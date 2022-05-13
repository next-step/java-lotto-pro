package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTest {
    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void beforeEach() {
        lottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Test
    void valid_로또_1개_생성() {
        assertThat(new Lotto(lottoNumbers)).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    void invalid_로또_1개_생성_숫자개수() {
        assertThatThrownBy(() -> {
            lottoNumbers.remove(0);
            lottoNumbers.remove(1);
            Lotto newLotto = new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않은 6개의 숫자를 입력해주세요.");
    }

    @Test
    void invalid_로또_1개_생성_숫자범위() {
        assertThatThrownBy(() -> {
            lottoNumbers.remove(lottoNumbers.size() - 1);
            lottoNumbers.add(new LottoNumber(999));
            Lotto newLotto = new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45의 숫자만 입력해주세요.");
    }
}