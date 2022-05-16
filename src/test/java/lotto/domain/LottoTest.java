package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("6자리가 아닌 로또 번호 생성 시 오류 테스트")
    void create_lotto_range_exception_test() {
        List<LottoNumber> lotto = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5));

        assertThatThrownBy(() -> new Lotto(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복 로또 번호 생성 시 오류 테스트")
    void create_lotto_overlap_test() {
        List<LottoNumber> lotto = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(5));

        assertThatThrownBy(() -> new Lotto(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 자동 생성 테스트")
    void create_auto_lotto_test() {
        Lotto lotto = Lotto.auto();
        assertThat(lotto.getClass()).isEqualTo(Lotto.class);
    }

    @Test
    @DisplayName("로또 번호 맞은 횟수 테스트")
    void lotto_matches_test() {
        List<LottoNumber> lotto = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        List<LottoNumber> lottoTwo = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(7));

        Lotto lottoTicket = new Lotto(lotto);

        assertThat(lottoTicket.matches(new Lotto(lotto))).isEqualTo(6);
        assertThat(lottoTicket.matches(new Lotto(lottoTwo))).isEqualTo(5);
    }
}
