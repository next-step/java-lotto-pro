package lotto.view;

public class BuyAmountInputView extends LottoInputView {

    public String readBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readUserInput();
    }

}
