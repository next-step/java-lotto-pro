package lottoauto.view;

import lottoauto.service.LottoTicket;
import lottoauto.util.InputNumberValidator;
import lottoauto.util.WinnerChecker;
import lottoauto.wrapper.LottoCount;
import lottoauto.wrapper.Lotto;
import lottoauto.wrapper.Price;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputViewer {

    private LottoTicket lottoTicket = new LottoTicket();
    private Map<Integer, Integer> winnerMap = new HashMap<>();
    private Price price;

    public Price getInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        Price price = new Price();
        price.makeNewTryTimes(sc.nextLine());
        this.price = price;
        return price;
    }

    public void inputLotto(Price price) {
        lottoTicket = new LottoTicket();
        lottoTicket.addAll(price);
        lottoTicket.printAll();
    }

    public Map<Integer, Integer> getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        InputNumberValidator inputNumberValidator = new InputNumberValidator(sc.nextLine());
        Lotto winNumbers = new Lotto(inputNumberValidator.getNumbers());

        makeDefaultWinnerMap(winnerMap);

        WinnerChecker winnerChecker = new WinnerChecker(winNumbers);
        winnerChecker.makeWinnerMap(lottoTicket, winnerMap);

        return winnerMap;
    }

    private void makeDefaultWinnerMap(Map<Integer, Integer> winnerMap) {
        winnerMap.put(LottoCount.FIRST.getValue(), 0);
        winnerMap.put(LottoCount.SECOND.getValue(), 0);
        winnerMap.put(LottoCount.THIRD.getValue(), 0);
        winnerMap.put(LottoCount.FOURTH.getValue(), 0);
    }
}
