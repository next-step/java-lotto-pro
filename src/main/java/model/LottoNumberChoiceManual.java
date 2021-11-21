package model;

import java.util.List;

import calculator.StringSplitParser;

public class LottoNumberChoiceManual implements LottoNumberChoiceStrategy {
	InputPollable inputPollable;

	public LottoNumberChoiceManual(InputPollable inputPollable) {
		this.inputPollable = inputPollable;
	}

	@Override
	public List<Integer> choose() {
		return StringSplitParser.parse(inputPollable.pollInput());
	}
}
