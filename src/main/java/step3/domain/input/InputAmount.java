package step3.domain.input;

import step3.domain.amount.Amount;

import static step3.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;

public class InputAmount implements Input<Amount> {

    @Override
    public Amount create(String input) {
        validateBlank(input);
        try {
            return new Amount(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_ALLOW_NUMBER.getMessage());
        }
    }
}
