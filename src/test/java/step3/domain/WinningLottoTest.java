package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @DisplayName("당첨로또 생성 테스트")
    @Test
    void 당첨로또_생성() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        WinningLotto winningLotto = new WinningLotto(lottoNumbers);

        assertThat(winningLotto).isInstanceOf(WinningLotto.class);
    }
}
