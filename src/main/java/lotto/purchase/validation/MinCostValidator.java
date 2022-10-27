package lotto.purchase.validation;

public class MinCostValidator implements PurchaseValidator {

    private static final int MIN_COST = 1000;

    @Override
    public void validate(String purchase) {
        if (Integer.parseInt(purchase) < MIN_COST) {
            throw new IllegalArgumentException(ERROR_MIN_COST_MESSAGE);
        }
    }
}
