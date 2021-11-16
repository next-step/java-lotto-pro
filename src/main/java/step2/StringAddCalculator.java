package step2;

import java.util.Arrays;
import java.util.stream.Collectors;

import step2.domain.NumberElement;
import step2.domain.NumberList;
import step2.domain.Text;
import step2.domain.TextSplitter;

public class StringAddCalculator {

	private StringAddCalculator() {
	}

	public static int splitAndSum(String splitTargetText) {

		TextSplitter textSplitter = new TextSplitter(new Text(splitTargetText));

		NumberList numberList = new NumberList(
			Arrays.stream(textSplitter.getSplitResult())
				.map(NumberElement::of)
				.collect(Collectors.toList()));

		return numberList.getSum();
	}
}
