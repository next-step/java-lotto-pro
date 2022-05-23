package lottoauto.view;

import lottoauto.service.LottoTicket;
import lottoauto.service.InputNumberValidator;
import lottoauto.util.WinnerChecker;
import lottoauto.util.Rank;
import lottoauto.wrapper.Lotto;
import lottoauto.wrapper.Number;
import lottoauto.wrapper.Price;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputViewer {

    private LottoTicket lottoTicket = new LottoTicket();
    private Map<Integer, Integer> winnerMap = new HashMap<>();


    public Price getInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        Price price = new Price();
        price.makeNewTryTimes(sc.nextLine());
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
        System.out.println("보너스 볼을 입력해 주세요.");
        Number bonusBall = new Number(sc.nextLine());
        Lotto winNumbers = new Lotto(inputNumberValidator.getNumbers(), bonusBall);
        makeDefaultWinnerMap(winnerMap);

        WinnerChecker winnerChecker = new WinnerChecker(lottoTicket, winNumbers);
        winnerChecker.makeWinnerMap(winnerMap);

        return winnerMap;
    }

    private void makeDefaultWinnerMap(Map<Integer, Integer> winnerMap) {
        Rank rank[] = Rank.values();

        for (Rank value : rank) {
            winnerMap.put(value.getLottoRank(), 0);
        }
    }
}
