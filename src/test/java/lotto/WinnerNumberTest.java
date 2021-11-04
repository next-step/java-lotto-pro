package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerNumberTest {

	@Test
	@DisplayName("당첨번호 리스트 객체 생성한다.")
	public void 당첨번호_리스트_생성() {
		String input = "1,2,3,4,5,6";
		WinnerNumber winnerNumber = new WinnerNumber(input);
		assertThat(winnerNumber.getWinnerNumber().getLottoNumbers().size()).isEqualTo(6);
	}

	@Test
	@DisplayName("로또번호(1,2,3,4,5,6), 당첨번호(1,2,3,7,8,9) 입력하여 3개 당첨 확인한다.")
	public void 로또번호_3개_당첨() {
		List<LottoNumber> lottoNumbers =
			IntStream.of(1, 2, 3, 4, 5, 6).mapToObj(LottoNumber::new).collect(Collectors.toList());
		WinnerNumber winnerNumber = new WinnerNumber("1,2,3,7,8,9");
		int strikeCount = winnerNumber.strikeCount(lottoNumbers);
		assertThat(strikeCount).isEqualTo(3);
	}

}