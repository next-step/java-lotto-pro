package lotto.view;

import java.io.IOException;

public class BuyAmountReader extends LottoReader{

    public String readBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readUserInput();
    }

}
