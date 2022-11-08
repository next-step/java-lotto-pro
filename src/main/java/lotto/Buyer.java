package lotto;

import lotto.common.exception.LottoNullException;

import java.util.List;
import java.util.Optional;

import static lotto.common.Constants.DEFAULT_PRICE;
import static lotto.common.Constants.INIT_NUM;
import static lotto.common.Constants.ZERO;

public class Buyer {

    private Money amount;
    private Lottos lottos;

    public Buyer(String inputMoney) {
        amount = new Money(inputMoney);
        lottos = new Lottos();
    }

    public Buyer(Lottos lottos) {
        this.lottos = lottos;
    }

    private void makeDirectInputLottoNumber(String directInputLottoNumber) {
        if (directInputLottoNumber.length() == ZERO) {
            return;
        }
        String[] lottosString = directInputLottoNumber.split("\n");
        Optional.ofNullable(lottosString)
                .orElseThrow(() -> new LottoNullException("수동으로 입력하신 숫자는 null 입니다."));

        for (String lotto : lottosString) {
            this.lottos.add(new Lotto(lotto));
        }
        amount.substractMoney(lottosString.length);
    }

    public int buyLotto() {
        int cnt = INIT_NUM;
        while (amount.getMoney() > 0) {
            lottos.add(new Lotto());
            this.amount.substractMoney(DEFAULT_PRICE);
            cnt++;
        }
        return cnt;
    }

    public int getAmount() {
        return amount.getMoney();
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    public void buyLotto(String directInputLottoNumber) {
        makeDirectInputLottoNumber(directInputLottoNumber);
    }
}
