package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class WinningLottoTicketTest {
	private static final LottoTicket ticket = new LottoTicket("1,2,3,4,5,6");

	@Test
	public void create() {
		LottoTicket lottoTicket = ticket;
		List<LottoNumber> bonusList = LottoTicket.getDefaultNumbers();
		bonusList.removeAll(lottoTicket.getNumbers());
		LottoNumber bonus = bonusList.get(0);

		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(lottoTicket, bonus);

		assertThat(winningLottoTicket.getBonus()).isEqualTo(bonus);
		assertThat(winningLottoTicket.getTicket().getNumbers()).hasSameElementsAs(lottoTicket.getNumbers());
	}

	@Test
	public void throwIllegalArgumentException_when_보너스볼중복() {
		LottoTicket lottoTicket = ticket;
		LottoNumber bonus = lottoTicket.getNumbers().get(0);

		assertThatThrownBy(() -> new WinningLottoTicket(lottoTicket, bonus))
			.isInstanceOf(IllegalArgumentException.class)
			.withFailMessage("보너스 볼을 다시");
	}
}
