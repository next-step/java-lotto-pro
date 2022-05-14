package lottoauto.domain;

import lottoauto.wrapper.Lotto;

public class WinnerChecker {
    private static int FIRST = 0;
    private static int SECOND = 0;
    private static int THIRD = 0;
    private static int FOURTH = 0;
    private static Lotto winnerLotto;
    public WinnerChecker(Lotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }

    public void checkMatchNumbers(Lotto compareLotto) {
        int count = 0;
        for(int i = 0 ; i < compareLotto.size() ; i++) {
            if(winnerLotto.contains(compareLotto.get(i))) {
                count++;
            }
        }
        System.out.println("count = " + count);
    }
}
