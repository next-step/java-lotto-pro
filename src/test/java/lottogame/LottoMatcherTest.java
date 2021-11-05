package lottogame;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoMatcherTest {

	@Test
	public void 정답과_로또티켓비교() {
		LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers("1, 5, 20, 34, 3, 40");
		List<Integer> numbers = Arrays.asList(1,5,12,26,30,40);
		LottoTicket lottoTicket = new LottoTicket(getLottoNumbers(numbers));
		int matchCount = LottoMatcher.matchCountWinningAndTicket(lottoWinningNumbers,lottoTicket);
		Assertions.assertThat(matchCount).isEqualTo(3);
	}

	private List<LottoNumber> getLottoNumbers(List<Integer> numbers) {
		return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
	}
}
