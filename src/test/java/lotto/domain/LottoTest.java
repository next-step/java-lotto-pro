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
        List<LottoNumber> lotto = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5));

        assertThatThrownBy(() -> new Lotto(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복 로또 번호 생성 시 오류 테스트")
    void create_lotto_overlap_test() {
        List<LottoNumber> lotto = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(5));

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
        List<LottoNumber> lotto = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));

        List<LottoNumber> lottoTwo = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(7));

        Lotto lottoTicket = new Lotto(lotto);
        assertThat(lottoTicket.matchCount(new Lotto(lotto))).isEqualTo(6);
        assertThat(lottoTicket.matchCount(new Lotto(lottoTwo))).isEqualTo(5);
    }
}
