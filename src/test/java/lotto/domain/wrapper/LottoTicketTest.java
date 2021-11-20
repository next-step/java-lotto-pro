package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.LottoOrder;

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
	@DisplayName("로또번호 중복없이 6개 입력하지 않을 경우 예외")
	@ParameterizedTest
	@CsvSource(value = {
		"1",
		"1,2,1,2,1,2",
		"1,2,3,4,5,6,7,8,9",
	})
	public void lottoOrderTest(String wrongLottoNumbers) {
		assertThatThrownBy(() -> new LottoTicket(wrongLottoNumbers))
			.isInstanceOf(IllegalArgumentException.class);

	}
}
