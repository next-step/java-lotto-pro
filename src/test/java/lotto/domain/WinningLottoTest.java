package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

	@Test
	@DisplayName("당첨 로또번호 6개와 보너스번호 1개로 생성한다")
	public void ofTest() {
		// given
		LottoTicket lottoNumbers = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber bonusNumber = LottoNumber.of(45);

		// when
		WinningLotto winningLotto = WinningLotto.of(lottoNumbers, bonusNumber);

		// then
		assertThat(winningLotto).isEqualTo(WinningLotto.of(lottoNumbers, bonusNumber));
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	@DisplayName("당첨 로또번호 6개와 보너스 번호 1개가 중복이 되면 안된다")
	public void ofValidateTest(int bonusIntNumber) {
		// given
		LottoTicket lottoNumbers = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber bonusNumber = LottoNumber.of(bonusIntNumber);

		// when, then
		assertThatThrownBy(() -> WinningLotto.of(lottoNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("로또티켓과 비교하여 당첨순위를 반환한다")
	public void getMatchRankTest() {
		LottoTicket ticket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 45));
		LottoTicket winningNumbers = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber bonusNumber = LottoNumber.of(45);
		WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);

		Rank rank = winningLotto.getMatchRank(ticket);

		assertThat(rank).isEqualTo(Rank.SECOND);
	}

}
