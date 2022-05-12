package lottoauto.domain;

import lottoauto.util.SixRandomNumberUtil;
import lottoauto.wrapper.Lotto;
import lottoauto.wrapper.LottoList;
import lottoauto.wrapper.Price;

public class LottoMaker {
    private final LottoList lottoList;
    Price price;

    public LottoMaker(String input) {
        price = new Price(input);
        System.out.println(price.getTryTimes()+"개를 구매했습니다.");
        lottoList = new LottoList(price.getTryTimes());

        for(int i = 0 ; i < price.getTryTimes() ; i ++) {
            System.out.println(lottoList.get(i).toString());
        }
    }

}
