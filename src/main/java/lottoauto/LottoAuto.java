package lottoauto;

import lottoauto.service.LottoTicket;
import lottoauto.util.InputNumberValidator;
import lottoauto.wrapper.Lotto;
import lottoauto.wrapper.Price;

import java.util.Scanner;

public class LottoAuto {
    private static Price price;
    private static LottoTicket lottoTicket = new LottoTicket();
    private static Lotto winNumbers;
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
    }
}
