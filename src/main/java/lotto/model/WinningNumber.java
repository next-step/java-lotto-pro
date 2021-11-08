package lotto.model;

public class WinningNumber {
    public static final String CONTAINS_MESSAGE = "당첨번호와 같은 보너스볼을 입력했습니다.";
    private final Lotto winningNumber;
    private final LottoNumber bonusBall;

    public WinningNumber(Lotto winningNumber, LottoNumber bonusBall) {
        validateContains(winningNumber, bonusBall);
        this.winningNumber = winningNumber;
        this.bonusBall = bonusBall;
    }

    private void validateContains(Lotto winningNumber, LottoNumber bonusBall) {
        if (winningNumber.contains(bonusBall)) {
            throw new IllegalArgumentException(CONTAINS_MESSAGE);
        }
    }

    public int winningCount(Lotto lotto) {
        return (int) winningNumber.getLotto().stream()
                .filter(lotto::contains).count();
    }
}
