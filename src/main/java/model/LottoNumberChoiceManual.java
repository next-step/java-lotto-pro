package model;

import java.util.List;

import calculator.StringSplitParser;
import view.InputView;

public class LottoNumberChoiceManual implements LottoNumberChoiceStrategy {
	@Override
	public List<Integer> choose() {
		return StringSplitParser.parse(InputView.pollInput());
	}
}
