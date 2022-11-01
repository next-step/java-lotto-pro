package step3.model;

import java.util.ArrayList;
import java.util.List;

import static step3.utils.CommonUtils.*;

import static step3.constant.Constant.Lotto.*;
import static step3.constant.Message.Error.*;

public class LottoGenerator {
    private int purchasePrice;
    private int purchaseCount;
    private Lottos lottos;

    public Lottos getLottos() {
        return lottos;
    }

    public int getPurchasedCount() {
        return purchaseCount;
    }

    public void setPurchasePrice(String price) {
        this.purchasePrice = validatePrice(price);
    }

    public Lottos generateLottos() {
        calculatePurchaseCount();
        addLottos();
        return lottos;
    }

    public void addLottos() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoList.add(new Lotto());
        }
        lottos = new Lottos(lottoList);
    }


    private int validatePrice(String price) {
        commonCheckEmpty(price);
        int integerPrice = commonStringToNumber(price);
        checkPriceMinLimit(integerPrice);

        return integerPrice;
    }

    public void calculatePurchaseCount() {
        purchaseCount = purchasePrice / EACH_LOTTO_PRICE;
    }

    private void checkPriceMinLimit(int price) {
        if (price < EACH_LOTTO_PRICE) {
            throw new IllegalArgumentException(UNDER_MIN_PRICE);
        }
    }

    public int getPurchasedCount() {
        return lottos.getPurchasedCount();
    }

}
