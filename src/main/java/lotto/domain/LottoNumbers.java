package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

	private List<LottoNumber> numbers = new ArrayList<>();

	public LottoNumbers(List<LottoNumber> list) {
		this.numbers.addAll(list);
	}

	public LottoNumbers() {
	}

	public int getSize() {
		return this.numbers.size();
	}

	public List<LottoNumber> getNumbers() {
		return Collections.unmodifiableList(numbers);
	}

	public void add(LottoNumber number) {
		this.numbers.add(number);
	}
	
}
