package lotto;

import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.ui.InputType;
import lotto.ui.InputView;

/**
 * packageName : lotto
 * fileName : LottoMain
 * author : haedoang
 * date : 2021-11-05
 * description : 로또 메인 클래스 생성
 */
public class LottoMain {
    public static void main(String[] args) {
        //구매 금액 입력
        PurchasePrice price = (PurchasePrice) InputView.readLine(InputType.PURCHASE);
        //지난 당첨 번호 입력
        Lotto lotto = (Lotto) InputView.readLine(InputType.NUMBER);
    }
}
