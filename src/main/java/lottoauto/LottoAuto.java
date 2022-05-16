package lottoauto;

import lottoauto.service.LottoTicket;
import lottoauto.util.InputNumberValidator;
import lottoauto.util.WinnerChecker;
import lottoauto.wrapper.Lotto;
import lottoauto.wrapper.Price;

import java.util.Scanner;

public class LottoAuto {
    private static Price price;
    private static LottoTicket lottoTicket = new LottoTicket();
    private static Lotto winNumbers;
    private static final String FOURTH_STR = "3개 일치(5000원)-";
    private static final String THIRD_STR = "4개 일치(50000원)-";
    private static final String SECOND_STR = "5개 일치(1500000원)-";
    private static final String FIRST_STR = "6개 일치(2000000000원)-";
    private static int FIRST = 0;
    private static int SECOND = 0;
    private static int THIRD = 0;
    private static int FOURTH = 0;
    public LottoAuto() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        price = new Price(sc.nextLine());
        for (int i = 0; i < price.getTryTimes(); i++) {
            lottoTicket.add(new Lotto());
        }
        lottoTicket.printAll();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        InputNumberValidator inputNumberValidator = new InputNumberValidator(sc.nextLine());
        winNumbers = new Lotto(inputNumberValidator.getNumbers());
        System.out.println(winNumbers.toString());
        WinnerChecker winnerChecker = new WinnerChecker(winNumbers);
        for(int i = 0 ; i < lottoTicket.size() ; i++) {
            if(winnerChecker.compareTickets(lottoTicket.get(i)) == 6) {
                FIRST++;
            }

            if(winnerChecker.compareTickets(lottoTicket.get(i)) == 5) {
                SECOND++;
            }

            if(winnerChecker.compareTickets(lottoTicket.get(i)) == 4) {
                THIRD++;
            }

            if(winnerChecker.compareTickets(lottoTicket.get(i)) == 3) {
                FOURTH++;
            }
        }

        System.out.println(FIRST_STR+" "+FIRST);
        System.out.println(SECOND_STR+" "+SECOND);
        System.out.println(THIRD_STR+" "+THIRD);
        System.out.println(FOURTH_STR+" "+FOURTH);

        System.out.println("총 수익률은 "+(price.getTryTimes() / (FIRST+SECOND+THIRD+FOURTH))+"입니다.");
    }
}
