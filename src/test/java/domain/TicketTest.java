package domain;

import domain.helper.FixedLottoFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

import static domain.LottoNumber.of;
import static java.util.Set.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @DisplayName("입력받은 금액만큼 로또를 구매한다.")
    @Test
    void buy() {
        Ticket ticket = Ticket.buy(new Money(5_000L), new RandomLottoFactory());
        assertThat(ticket.getElements()).hasSize(5);
    }


    @DisplayName("구매한 로또와 당첨 번호를 비교한다.")
    @Test
    void check() {
        //given
        Deque<Lotto> fixture = new LinkedList<>();
        fixture.push(new Lotto(Set.of(of(1), of(2), of(3), of(4), of(5), of(6))));
        fixture.push(new Lotto(Set.of(of(1), of(2), of(3), of(7), of(8), of(9))));
        Lotto wining = new Lotto(Set.of(of(1), of(2), of(3), of(4), of(5), of(6)));
        Ticket ticket = Ticket.buy(new Money(2_000L), new FixedLottoFactory(fixture));
        //when
        Rewards rewards = ticket.check(wining);

        assertThat(rewards.count(Reward.FIRST)).isEqualTo(1);
        assertThat(rewards.count(Reward.FOURTH)).isEqualTo(1);
        assertThat(rewards.count(Reward.MISS)).isEqualTo(0);
    }
}
