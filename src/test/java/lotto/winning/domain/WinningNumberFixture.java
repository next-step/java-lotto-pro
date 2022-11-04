package lotto.winning.domain;

public class WinningNumberFixture {
    public static WinningNumber 당첨번호123456() {
        String[] numbers = {"1", "2", "3", "4", "5", "6"};
        return new WinningNumber(numbers);
    }
}
