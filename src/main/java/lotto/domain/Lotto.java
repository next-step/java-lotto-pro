package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final int GAME_PRICE = 1000;

    private List<LottoNumber> lottoNumbers;

    public Lotto(int purchaseAmount) {
        this.lottoNumbers = purchaseLotto(purchaseAmount);
    }

    private List<LottoNumber> purchaseLotto(int purchaseAmount) {
        int purchaseCount = getPurchaseCount(purchaseAmount);

        List<LottoNumber> lottoNumbers = getLottoList(purchaseCount);
        return lottoNumbers;
    }

    private List<LottoNumber> getLottoList(int purchaseAmount) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottoNumbers.add(new LottoNumber());
        }
        return lottoNumbers;
    }

    private int getPurchaseCount(int purchaseAmount) {
        validation(purchaseAmount);
        return purchaseAmount / GAME_PRICE;
    }

    private void validation(int purchaseAmount) {
        validateZeroAmount(purchaseAmount);
        validateRemainderAmount(purchaseAmount);
    }

    private void validateRemainderAmount(int purchaseAmount) {
        if (purchaseAmount % GAME_PRICE > 0) {
            System.out.println("[ERROR] 구입 시도 금액이 잘못되었습니다.");
            throw new IllegalArgumentException("[ERROR] 구입 시도 금액이 잘못되었습니다.");
        }
    }

    private void validateZeroAmount(int purchaseAmount) {
        if (purchaseAmount == 0) {
            System.out.println("[ERROR] 구입 할 금액을 입력해주세요.");
            throw new IllegalArgumentException("[ERROR] 구입 할 금액을 입력해주세요.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
