package step3.domain.input;

import step3.domain.Amount;
import step3.domain.PurchasingAmount;

import static step3.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;

public class InputPurchasingAmount implements Input<PurchasingAmount> {

    @Override
    public PurchasingAmount create(String input) {
        validateBlank(input);
        try {
            return new PurchasingAmount(new Amount(Integer.parseInt(input)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_ALLOW_NUMBER.getMessage());
        }
    }
}
