package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
	public static int LOTTO_NUMBER_COUNT = 6;

	@DisplayName("중복된 로또번호 없음")
	@Test
	public void hasNotDuplicateNumbers() {
		LottoTicket lottoTicket = new LottoTicket();

		assertThat(lottoTicket.getNumbers().size())
			.isEqualTo(new HashSet<>(lottoTicket.getNumbers()).size());
	}

	@DisplayName("로또번호는 총 6개")
	@Test
	public void lottoNumberCountIsSix() {
		LottoTicket lottoTicket = new LottoTicket();

		assertThat(lottoTicket.getNumbers().size())
			.isEqualTo(LOTTO_NUMBER_COUNT);
	}
}
