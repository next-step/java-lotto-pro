package calculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Numbers implements Iterable<Integer> {

	private final List<Integer> numbers = new ArrayList<>();

	public void add(int number) throws IllegalArgumentException {
		this.numbers.add(number);
	}

	@Override
	public Iterator<Integer> iterator() {
		return this.numbers.iterator();
	}
}
