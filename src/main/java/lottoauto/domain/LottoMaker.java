package lottoauto.domain;

import lottoauto.wrapper.Price;

public class LottoMaker {

    Price price;

    public LottoMaker(String input, LottoList lottoList) {
        price = new Price(input);
        System.out.println(price.getTryTimes()+"개를 구매했습니다.");
        lottoList = new LottoList(price.getTryTimes());

        for(int i = 0 ; i < price.getTryTimes() ; i ++) {
            System.out.println(lottoList.get(i).toString());
        }
    }


}
