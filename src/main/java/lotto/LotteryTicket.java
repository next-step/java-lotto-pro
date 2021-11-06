package lotto;

import lotto.view.InputView;

import java.util.Collections;
import java.util.List;

public class LotteryTicket {
    private final List<Integer> lottoTicket;

    public LotteryTicket(List<Integer> autoPickedLottoNumber) {
        Collections.sort(autoPickedLottoNumber);
        this.lottoTicket = autoPickedLottoNumber;
    }

    public int size() {
        return lottoTicket.size();
    }

    public int countMatch(String[] winningNumber) {
        int cnt = 0;
        for (int i = 0 ; i < winningNumber.length ; i++) {
            cnt = countContain(winningNumber, cnt, i);
        }
        return cnt;
    }

    private int countContain(String[] winningNumber, int cnt, int i) {
        if (lottoTicket.contains(Integer.parseInt(winningNumber[i]))) {
            cnt++;
        }
        return cnt;
    }

    public void printLottoNumber() {
        InputView.printLottoTicketNumber(lottoTicket);
    }
}
