package lotto.model;

public class WinningLotto {

    private final Lotto lotto;
    private final Number bonusNo;

    private WinningLotto(Lotto lotto, Number bonusNo) {
        if (lotto.contains(bonusNo)) {
            throw new IllegalArgumentException("이미 존재하는 번호 입니다.");
        }

        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public static WinningLotto of(String input, String bonusNo) {
        Lotto winnerNumbers = new Lotto(new InputNumberGenerator(input));
        Number bonusNumber = new Number(bonusNo);
        return new WinningLotto(winnerNumbers, bonusNumber);
    }

    public boolean contains(Number number) {
        return lotto.contains(number);
    }

    public int countOfMatchNumber(Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(this.lotto::contains)
                .count();
    }

    public boolean containsBonusNumber(Lotto userLotto) {
        return userLotto.contains(bonusNo);
    }
}
