package lotto.domain;

public class TestResultMessageStrategy implements ResultMessageStrategy {
	@Override
	public String resultMessage(int winningQuantity) {
		return "testResultMessage";
	}
}
