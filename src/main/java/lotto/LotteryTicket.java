package lotto;

import java.util.Collections;
import java.util.List;

public class LotteryTicket {
    private final List<Integer> lottoTicket;

    public LotteryTicket(List<Integer> autoPickedLottoNumber) {
        Collections.sort(autoPickedLottoNumber);
        this.lottoTicket = autoPickedLottoNumber;
    }

    public static LotteryTicket createAutoLotteryNumber(List<Integer> autoPickedLottoNumber) {
        return new LotteryTicket(autoPickedLottoNumber);
    }

    public int size() {
        return lottoTicket.size();
    }

    public int countMatch(WinningNumber winningNumber) {
        int cnt = 0;
        for (String no : winningNumber.getWinningNumber()) {
            if (lottoTicket.contains(Integer.parseInt(no))) {
                cnt++;
            }
        }
        return cnt;
    }

    public List<Integer> getLotteryNumber() {
        return lottoTicket;
    }

    public boolean isMatchBonus(WinningNumber winningNumber) {
        return lottoTicket.contains(winningNumber.getBonusNumber());
    }
}
