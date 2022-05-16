package lotto.enums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    void 로또_당첨이_되지않은_경우() {
        assertThat(LottoRank.find(1)).isEqualTo(LottoRank.NONE);
    }

    @Test
    void 로또_당첨개수가_3개인_경우() {
        assertThat(LottoRank.find(3)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 로또_당첨개수가_4개인_경우() {
        assertThat(LottoRank.find(4)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 로또_당첨개수가_5개인_경우() {
        assertThat(LottoRank.find(5)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 로또_당첨개수가_6개인_경우() {
        assertThat(LottoRank.find(6)).isEqualTo(LottoRank.FIRST);
    }
}
