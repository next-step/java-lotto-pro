package edu.lotto.automatic.model;

import edu.lotto.automatic.utils.NumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 로또 번호를 저장하는 Model
 * @since 2021.11.04
 * @author Inmook,Jeong
 */
public class Lotto {

	private List<Integer> lottoNumbers;

	public Lotto() {
		this.lottoNumbers = setLottoNumber();
		System.out.println("lottoNumbers : " + lottoNumbers.toString());
	}

	private List<Integer> setLottoNumber() {
		List<Integer> lottoNumberList = new ArrayList<Integer>();
		while(lottoNumberList.size() < 6) {
			addNotDuplicatedNumber(lottoNumberList);
		}
		Collections.sort(lottoNumberList);
		return lottoNumberList;
	}

	private void addNotDuplicatedNumber(List<Integer> lottoNumberList) {
		int randomNumber = NumberUtil.getNumberBetweenOneAndFortyFive();
		if(!lottoNumberList.contains(randomNumber)) {
			lottoNumberList.add(randomNumber);
		}
	}
}
