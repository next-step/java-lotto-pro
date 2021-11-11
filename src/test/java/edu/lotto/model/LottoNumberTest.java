package edu.lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberTest {

	private List<LottoNumber> winningNumbers;

	@BeforeEach
	void setWinningNumbers() {
		winningNumbers = new ArrayList<LottoNumber>();
		winningNumbers.add(new LottoNumber(1));
		winningNumbers.add(new LottoNumber(10));
		winningNumbers.add(new LottoNumber(15));
		winningNumbers.add(new LottoNumber(21));
		winningNumbers.add(new LottoNumber(34));
		winningNumbers.add(new LottoNumber(42));
	}

	@Test
	@DisplayName("로또 번호가 지난 주 정답에 포함되어 있는지 검증")
	void containLottoNumber() {
		boolean hasLottoNumber = false;
		LottoNumber number = new LottoNumber(1);
		long containCunt = winningNumbers.stream()
									.filter(lottoNumber -> lottoNumber.getLottoNumber() == number.getLottoNumber())
									.count();
		assertThat(containCunt).isNotEqualTo(0);
	}
}
