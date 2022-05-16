package lottoauto.view;

import lottoauto.service.LottoTicket;
import lottoauto.util.InputNumberValidator;
import lottoauto.util.WinnerChecker;
import lottoauto.wrapper.Lotto;
import lottoauto.wrapper.Price;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputViewer {


    private static final int FOURTH = 3;
    private static final int THIRD = 4;
    private static final int SECOND = 5;
    private static final int FIRST = 6;
    LottoTicket lottoTicket = new LottoTicket();
    Price price;

    public Price getInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        Price price = new Price(sc.nextLine());
        this.price = price;
        return price;
    }

    public void inputLottoPrint() {
        for (int i = 0; i < price.getTryTimes(); i++) {
            lottoTicket.add(new Lotto());
        }
        lottoTicket.printAll();
    }

    public Map<Integer, Integer> getWinNumbers() {


        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        InputNumberValidator inputNumberValidator = new InputNumberValidator(sc.nextLine());
        Lotto winNumbers = new Lotto(inputNumberValidator.getNumbers());

        Map<Integer, Integer> winnerMap = new HashMap<>();
        makeDefaultWinnerMap(winnerMap);

        WinnerChecker winnerChecker = new WinnerChecker(winNumbers);
        winnerChecker.makeWinnerMap(lottoTicket, winnerMap);

        return winnerMap;
    }


    private void makeDefaultWinnerMap(Map<Integer, Integer> winnerMap) {
        winnerMap.put(FIRST, 0);
        winnerMap.put(SECOND, 0);
        winnerMap.put(THIRD, 0);
        winnerMap.put(FOURTH, 0);
    }
}
