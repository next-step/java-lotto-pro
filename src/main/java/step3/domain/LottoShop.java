package step3.domain;

public class LottoShop {
    private int LOTTO_PRICE = 1000;

    public int buy(Money money){
        return money.getMoney() / LOTTO_PRICE;
    }

}
