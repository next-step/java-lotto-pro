package lottoauto.view;

import lottoauto.service.LottoTicket;
import lottoauto.service.InputNumberValidator;
import lottoauto.util.Rank;
import lottoauto.wrapper.*;
import lottoauto.wrapper.Number;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputViewer {

    private LottoTicket lottoTicket = new LottoTicket();
    private final Map<Integer, Integer> winnerMap = new HashMap<>();


    public Price getInputPrice(int divide) {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return new Price(sc.nextLine(), divide);
    }

    public void inputLotto(TryTime tryTime) {
        lottoTicket = new LottoTicket();
        inputManualLotto(tryTime);
        addManualLotto(tryTime);
        printTryTimes(tryTime);
        lottoTicket.addAll(tryTime);
        lottoTicket.printAll();
    }


    private TryTime inputManualLotto(TryTime tryTime) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        tryTime.makeManualTryTimes(sc.nextLine());
        return tryTime;
    }

    private void addManualLotto(TryTime tryTime) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < tryTime.getManualTryTimes(); i++) {
            InputNumberValidator inputNumberValidator = new InputNumberValidator(sc.nextLine());
            lottoTicket.add(new Lotto(inputNumberValidator.getNumbers()));
        }
    }


    public static void printTryTimes(TryTime tryTime) {
        System.out.println("수동으로 " + tryTime.getManualTryTimes() + "장 자동으로 " + tryTime.getTryTimes() + "개를 구매했습니다.");
    }

    public Map<Integer, Integer> getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        InputNumberValidator inputNumberValidator = new InputNumberValidator(sc.nextLine());
        System.out.println("보너스 볼을 입력해 주세요.");
        Number numberValidator = new Number(sc.nextLine());
        LottoNo bonusBall = new LottoNo(numberValidator.getNumber());
        Lotto winNumbers = new Lotto(inputNumberValidator.getNumbers());
        makeDefaultWinnerMap(winnerMap);

        LottoTicket winnerChecker = new LottoTicket(lottoTicket.getListLotto(), winNumbers, bonusBall);
        winnerChecker.makeWinnerMap(winnerMap);

        return winnerMap;
    }

    private void makeDefaultWinnerMap(Map<Integer, Integer> winnerMap) {
        Rank[] rank = Rank.values();

        for (Rank value : rank) {
            winnerMap.put(value.getLottoRank(), 0);
        }
    }
}
