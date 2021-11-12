package edu.lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lotto Test Code
 * @since 2021.11.04
 * @author Inmook,Jeong
 */
public class LottoTest {

	private List<Integer> winningNumbers;
	private List<Integer> myLottoNumbers;
	private List<LottoNumber> newLottoNumbers;

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

	@BeforeEach
	void setNewLottoNumbers() {
		newLottoNumbers = new ArrayList<LottoNumber>();
		newLottoNumbers.add(new LottoNumber(1));
		newLottoNumbers.add(new LottoNumber(42));
		newLottoNumbers.add(new LottoNumber(22));
		newLottoNumbers.add(new LottoNumber(9));
		newLottoNumbers.add(new LottoNumber(33));
		newLottoNumbers.add(new LottoNumber(15));
	}

	@Test
	@DisplayName("로또 번호 정렬 확인")
	void sortLottoNumber() {
		Collections.sort(newLottoNumbers, comparator);
		for(int i=0; i<newLottoNumbers.size(); i++) {
			assertThat(newLottoNumbers.get(i).toString()).isEqualTo(String.valueOf(myLottoNumbers.get(i)));
		}
	}

	Comparator<LottoNumber> comparator = new Comparator<LottoNumber>() {
		@Override
		public int compare(LottoNumber l1, LottoNumber l2) {
			return l1.getLottoNumber() - l2.getLottoNumber();
		}
	};

	@Test
	@DisplayName("로또 번호가 지난 주 정답에 포함되어 있는지 검증")
	void containBonusBall() {
		int bonusBall = 42;
		long containCunt = newLottoNumbers.stream()
								.filter(lottoNumber -> lottoNumber.getLottoNumber() == bonusBall)
								.count();
		assertThat(containCunt).isNotEqualTo(0);
	}
}
