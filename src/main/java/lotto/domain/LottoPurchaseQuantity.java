package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoPurchaseQuantity {

    private final Map<LottoPurchaseType, Integer> purchaseQuantity;

    public LottoPurchaseQuantity() {
        this.purchaseQuantity = new HashMap<>();
        Arrays.stream(LottoPurchaseType.values())
                .forEach(lottoPurchaseType -> purchaseQuantity.put(lottoPurchaseType, 0));
    }

    public void addPurchaseQuantity(LottoPurchaseType lottoPurchaseType, int quantity) {
        purchaseQuantity.put(lottoPurchaseType, quantity);
    }

    public int findPurchaseQuantity(LottoPurchaseType lottoPurchaseType) {
        return purchaseQuantity.get(lottoPurchaseType);
    }

}
