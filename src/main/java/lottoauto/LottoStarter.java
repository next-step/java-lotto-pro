package lottoauto;

import lottoauto.wrapper.Price;

public class LottoStarter {
    Price price = new Price();
    public void startLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        price.setInput();
        System.out.println(price.getCount()+"개를 구매했습니다.");
    }


}
