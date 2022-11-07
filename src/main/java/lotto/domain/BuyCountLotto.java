package lotto.domain;

public class BuyCountLotto {

    private int directBuyCount;
    private BuyAmount buyAmount;

    public BuyCountLotto(int directBuyCount, BuyAmount buyAmount) {
        this.buyAmount = buyAmount;
        if(!buyAmount.isValidDirectBuyCount(directBuyCount)) {
            throw new IllegalArgumentException("구입금액보다 많은 숫자만큼 로또를 수동으로 구매할 수 없습니다.");
        }
        this.directBuyCount = directBuyCount;
    }

    public Lotteries getLotteries(LottoCreator lottoCreator, Lotteries lotteries) {
        if(!lotteries.isEqualSize(directBuyCount)) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수 " + directBuyCount + "만큼 번호를 입력해 주세요.");
        }
        return lotteries.union(buyAmount.getLotteries(lottoCreator, directBuyCount));
    }
}
