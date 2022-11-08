package lotto.domain.lotto;

public class Fixture {
    public static NumberPickStrategy pick123456() {
        return new Pick123456Strategy();
    }

    public static WinningNumbers winningNumbers123456() {
        final LottoNumbers winningNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        final LottoNumber bonus = new LottoNumber(7);
        return new WinningNumbers(winningNumbers, bonus);
    }

    public static Money lottoUnitPrice1000() {
        return new Money(1000);
    }
}
