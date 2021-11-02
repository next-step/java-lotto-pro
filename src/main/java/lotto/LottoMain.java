package lotto;

import lotto.domain.Seller;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        int money = InputView.printInputMoney();
        int countOfLotto = Seller.returnLotto(money);
        OutputView.printLottoCount(countOfLotto);

    }

}
