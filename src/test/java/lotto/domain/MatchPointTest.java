package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchPointTest {

	@Test
	@DisplayName("로또 번호 일치 횟수를 통해 총 당첨금을 계산해야 한다")
	public void getPrizeTest() {
		// given
		MatchPoint matchPoint = new MatchPoint(1, 0, 0, 0);

		// when
		int result = matchPoint.getPrize();

		// then
		assertThat(result).isEqualTo(2000000000);
	}

	@Test
	@DisplayName("로또 당첨번호와 로또 번호들로 총 당첨금을 계산해야 한다")
	public void getPrizeTestByLottoNumbers() {
		// given
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
		LottoNumber answer = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
		MatchPoint matchPoint = new MatchPoint(answer, lottoNumbers);

		// when
		int result = matchPoint.getPrize();

		// then
		assertThat(result).isEqualTo(2000000000);
	}

}
