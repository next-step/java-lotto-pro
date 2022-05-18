package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AnswerTest {
    Lotto lotto123456 = new Lotto(1, 2, 3, 4, 5, 6);

    @Test
    void 당첨번호_보너스볼_생성() {
        assertThat(new Answer(lotto123456, Number.from(7))).isNotNull();
    }

    @Test
    void 당첨번호_보너스볼_중복() {
        assertThatThrownBy(() -> new Answer(lotto123456, Number.from(5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨금_6개_일치() {
        Answer answer = new Answer(new Lotto(1, 2, 3, 4, 5, 6), Number.from(45));
        Winning winning = answer.winning(lotto123456);
        assertThat(winning.getMoney()).isEqualTo(2000000000);
    }

    @Test
    void 당첨금_5개_보너스_일치() {
        Answer answer = new Answer(new Lotto(1, 2, 3, 4, 5, 7), Number.from(6));
        Winning winning = answer.winning(lotto123456);
        assertThat(winning.getMoney()).isEqualTo(30000000);
    }

    @Test
    void 당첨금_5개_일치() {
        Answer answer = new Answer(new Lotto(1, 2, 3, 4, 5, 7), Number.from(45));
        Winning winning = answer.winning(lotto123456);
        assertThat(winning.getMoney()).isEqualTo(1500000);
    }

    @Test
    void 당첨금_4개_일치() {
        Answer answer = new Answer(new Lotto(1, 2, 3, 4, 7, 8), Number.from(45));
        Winning winning = answer.winning(lotto123456);
        assertThat(winning.getMoney()).isEqualTo(50000);
    }

    @Test
    void 당첨금_3개_일치() {
        Answer answer = new Answer(new Lotto(1, 2, 3, 7, 8, 9), Number.from(45));
        Winning winning = answer.winning(lotto123456);
        assertThat(winning.getMoney()).isEqualTo(5000);
    }
}
