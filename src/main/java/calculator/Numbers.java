package calculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Numbers implements Iterable<Integer> {

	private List<Integer> numbers = new ArrayList<>();

	public void add(int number) throws IllegalArgumentException {
		validateNumber(number);
		this.numbers.add(number);
	}

	public int get(int index) {
		return this.numbers.get(index);
	}

	public int size() {
		return this.numbers.size();
	}

	private void validateNumber(Integer number) {
		if (number < 0) {
			throw new IllegalArgumentException("음수는 입력하실 수 없습니다");
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return this.numbers.iterator();
	}
}
