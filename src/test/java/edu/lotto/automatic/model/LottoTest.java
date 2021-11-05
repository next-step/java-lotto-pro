package edu.lotto.automatic.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Lotto Test Code
 * @since 2021.11.04
 * @author Inmook,Jeong
 */
public class LottoTest {

	private List<Integer> winningNumbers;
	private List<Integer> myLottoNumbers;

	@BeforeEach
	void setWinningNumbers() {
		winningNumbers = new ArrayList<Integer>();
		winningNumbers.add(1);
		winningNumbers.add(10);
		winningNumbers.add(15);
		winningNumbers.add(21);
		winningNumbers.add(34);
		winningNumbers.add(42);
	}

	@BeforeEach
	void setMyLottoNumbers() {
		myLottoNumbers = new ArrayList<Integer>();
		myLottoNumbers.add(1);
		myLottoNumbers.add(9);
		myLottoNumbers.add(15);
		myLottoNumbers.add(22);
		myLottoNumbers.add(33);
		myLottoNumbers.add(42);
	}

	@Test
	@DisplayName("지난주 당첨 번호와 내 로또 번호가 일치하는 숫자가 몇개인지 확인")
	void setWinningNumberMatchesCount() {
		long matchedCount = myLottoNumbers.stream().filter(number -> winningNumbers.contains(number)).count();
		assertThat(matchedCount).isEqualTo(3);
	}
}
