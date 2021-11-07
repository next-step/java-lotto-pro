package lottoservice.matcher;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.lottonumber.LottoArrangeManipulator;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;
import lottoservice.lottoticket.LottoTicket;
import lottoservice.lottoticket.LottoTickets;

public class LottoWinningNumbersTest {

	private static int SIZE_OF_LOTTERY_NUMBERS = 6;

	LottoNumbersMaker lottoNumbersMaker = new LottoNumbersMaker(new LottoArrangeManipulator());

	@Test
	public void makeLottoWinningNumbers_당첨번호_생성() {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(Arrays.asList(3, 34, 22, 17, 26, 7));
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers);

		assertThat(lottoWinningNumbers.sizeOfWinningNumbers()).isEqualTo(lottoNumbers.size());

		lottoNumbers.stream().forEach(it -> assertThat(lottoWinningNumbers.hasMatchNumber(it)).isTrue());
	}

	@Test
	public void validateLottoNumberGroupRule_당첨번호_리스트_중복숫자_입력_예외() {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(Arrays.asList(3, 34, 22, 17, 3, 7));

		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@Test
	public void validateLottoNumberGroupRule_당첨번호_리스트_갯수가_작은경우_예외() {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 22, 17, 3, 7));

		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@Test
	public void validateLottoNumberGroupRule_당첨번호_리스트_갯수가_큰_경우_예외() {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 22, 17, 3, 7, 30, 45));

		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1, 31, 22, 15, 4, 7", "2, 43, 33, 25, 6, 7"})
	public void makeLottoWinningNumbers_당첨번호_문자열_입력(String lottoNumberText) {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(lottoNumberText);
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers);

		assertThat(lottoWinningNumbers.sizeOfWinningNumbers()).isEqualTo(lottoNumbers.size());

		lottoNumbers.stream().forEach(it -> assertThat(lottoWinningNumbers.hasMatchNumber(it)).isTrue());
	}

	@ParameterizedTest
	@ValueSource(strings = {"1, 31, 22, 15, 4, 7, 5", "2, 43, 33, 25, 6"})
	public void makeLottoWinningNumbers_당첨번호_문자열_입력_로또갯수_예외(String lottoNumberText) {
		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(
				lottoNumbersMaker.makeLottoNumbers(lottoNumberText));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,31,22,15,4,7", " 2, 43, 33, 25, 6, 10", "2, 43, 33, 25, 6, 10 ", "2 43 33 25 6 10"})
	public void makeLottoWinningNumbers_당첨번호_문자열_입력_포맷_예외(String lottoNumberText) {
		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(
				lottoNumbersMaker.makeLottoNumbers(lottoNumberText));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@Test
	public void matchWinningAndTickets_정답과_로또티켓들_비교결과() {
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(
			lottoNumbersMaker.makeLottoNumbers("1, 5, 20, 34, 3, 40"));

		List<LottoTicket> tickets = new ArrayList<>();
		tickets.add(new LottoTicket(lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 5, 12, 26, 30, 40))));
		tickets.add(new LottoTicket(lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 5, 3, 34, 20, 40))));

		LottoMatchResult lottoMatchResult = lottoWinningNumbers.matchWinningAndTickets(new LottoTickets(tickets));

		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.ZERO_POINT)).isEqualTo(0);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.SIX_POINT)).isEqualTo(1);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.THREE_POINT)).isEqualTo(1);
	}

	@Test
	public void matchWinningAndTickets_당첨_수익률_계산() {
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(
			lottoNumbersMaker.makeLottoNumbers("1, 5, 20, 34, 3, 40"));

		List<LottoTicket> tickets = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			tickets.add(new LottoTicket(lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 6, 11, 25, 32, 44))));
		}
		tickets.add(new LottoTicket(lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 4, 12, 26, 30, 40))));
		tickets.add(new LottoTicket(lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 2, 31, 34, 20, 40))));

		LottoTickets lottoTickets = new LottoTickets(tickets);
		LottoMatchResult lottoMatchResult = lottoWinningNumbers.matchWinningAndTickets(lottoTickets);

		Assertions.assertThat(lottoMatchResult.calculateProfitPercentage()).isEqualTo(2.27);
	}
}