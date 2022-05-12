package lottoauto;

import lottoauto.wrapper.Lotto;
import lottoauto.wrapper.LottoList;
import lottoauto.wrapper.Price;

public class LottoStarter {
    Price price = new Price();
    Lotto lotto = new Lotto();
    LottoList lottoList = new LottoList();
    public void startLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        price.setInput();
        System.out.println(price.getCount()+"개를 구매했습니다.");

        for (int i = 0; i < price.getCount(); i++) {
            lottoList.addLotto(lotto.getLotto());
        }

        lottoList.printAllLottos();

    }


}
