package lottoservice.matcher;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;
import lottoservice.lottoticket.LottoTicket;
import lottoservice.lottoticket.LottoTickets;

public class LottoWinningNumbersTest {

	private static int SIZE_OF_LOTTERY_NUMBERS = 6;

	@ParameterizedTest
	@CsvSource({"3,34,22,17,26,7"})
	public void makeLottoWinningNumbers_당첨번호_리스트_입력(ArgumentsAccessor argumentsAccessor) {
		List<Integer> numbers = convertArgumentsToInteger(argumentsAccessor);
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(LottoNumbersMaker.makeLottoNumbers(numbers));
		assertThat(lottoWinningNumbers.sizeOfWinningNumbers()).isEqualTo(numbers.size());

		List<LottoNumber> lottoNumbers = convertToLottoNumbers(numbers);
		for (LottoNumber lottoNumber : lottoNumbers) {
			assertThat(lottoWinningNumbers.hasMatchNumber(lottoNumber)).isTrue();
		}
	}

	@ParameterizedTest
	@CsvSource({"34,3,17,26,7,3"})
	public void validateHasNotDuplicateLottoNumber_당첨번호_리스트_중복숫자_입력_예외(ArgumentsAccessor argumentsAccessor) {
		List<Integer> numbers = convertArgumentsToInteger(argumentsAccessor);
		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(LottoNumbersMaker.makeLottoNumbers(numbers));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@CsvSource({"34,3,17,26,7"})
	public void validateSizeOfLotto_당첨번호_리스트_갯수가_작은경우_예외(ArgumentsAccessor argumentsAccessor) {
		List<Integer> numbers = convertArgumentsToInteger(argumentsAccessor);
		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(LottoNumbersMaker.makeLottoNumbers(numbers));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@CsvSource({"34,3,17,26,7,10,32"})
	public void validateSizeOfLotto_당첨번호_리스트_갯수가_큰경우_예외(ArgumentsAccessor argumentsAccessor) {
		List<Integer> numbers = convertArgumentsToInteger(argumentsAccessor);
		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(LottoNumbersMaker.makeLottoNumbers(numbers));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1, 31, 22, 15, 4, 7", "2, 43, 33, 25, 6, 7"})
	public void makeLottoWinningNumbers_당첨번호_문자열_입력(String lottoNumberText) {
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(LottoNumbersMaker.makeLottoNumbers(lottoNumberText));
		assertThat(lottoWinningNumbers.sizeOfWinningNumbers()).isEqualTo(SIZE_OF_LOTTERY_NUMBERS);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1, 31, 22, 15, 4, 7, 5", "2, 43, 33, 25, 6"})
	public void makeLottoWinningNumbers_당첨번호_문자열_입력_로또갯수_예외(String lottoNumberText) {
		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(LottoNumbersMaker.makeLottoNumbers(lottoNumberText));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,31,22,15,4,7", " 2, 43, 33, 25, 6, 10","2, 43, 33, 25, 6, 10 ","2 43 33 25 6 10"})
	public void makeLottoWinningNumbers_당첨번호_문자열_입력_포맷_예외(String lottoNumberText) {
		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(LottoNumbersMaker.makeLottoNumbers(lottoNumberText));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	// ArgumentsAccessor 타입을 Integer List로 변환
	private List<Integer> convertArgumentsToInteger(ArgumentsAccessor argumentsAccessor) {
		return argumentsAccessor.toList()
			.stream()
			.map(argument -> Integer.parseInt(String.valueOf(argument)))
			.collect(Collectors.toList());
	}

	// LottoNumber를 Set으로 담은 자료구조를 primitive 타입 int로 찾기 어려우므로 LottoNumber로 래핑
	private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
		return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
	}

	@Test
	public void matchWinningAndTickets_정답과_로또티켓들_비교결과() {
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(LottoNumbersMaker.makeLottoNumbers("1, 5, 20, 34, 3, 40"));

		List<LottoTicket> tickets = new ArrayList<>();
		tickets.add(new LottoTicket(getLottoNumbers(Arrays.asList(1,5,12,26,30,40))));
		tickets.add(new LottoTicket(getLottoNumbers(Arrays.asList(1,5,3,34,20,40))));


		LottoTickets lottoTickets = new LottoTickets(tickets);
		LottoMatchResult lottoMatchResult = lottoWinningNumbers.matchWinningAndTickets(lottoTickets);

		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.SIX_POINT)).isEqualTo(1);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.THREE_POINT)).isEqualTo(1);
	}

	@Test
	public void matchWinningAndTickets_당첨_수익률_계산() {
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(LottoNumbersMaker.makeLottoNumbers("1, 5, 20, 34, 3, 40"));

		List<LottoTicket> tickets = new ArrayList<>();
		for(int i=0; i<20; i++){
			tickets.add(new LottoTicket(getLottoNumbers(Arrays.asList(1,6,11,25,32,44))));
		}
		tickets.add(new LottoTicket(getLottoNumbers(Arrays.asList(1,4,12,26,30,40))));
		tickets.add(new LottoTicket(getLottoNumbers(Arrays.asList(1,2,31,34,20,40))));


		LottoTickets lottoTickets = new LottoTickets(tickets);
		LottoMatchResult lottoMatchResult = lottoWinningNumbers.matchWinningAndTickets(lottoTickets);

		Assertions.assertThat(lottoMatchResult.calculateProfitPercentage()).isEqualTo(2.27);
	}

	private List<LottoNumber> getLottoNumbers(List<Integer> numbers) {
		return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
	}

}
