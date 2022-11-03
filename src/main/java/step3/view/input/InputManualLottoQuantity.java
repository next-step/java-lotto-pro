package step3.view.input;

import static step3.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;

public class InputManualLottoQuantity implements Input<Integer> {

    @Override
    public Integer create() {
        String input = scanner.nextLine();
        validateBlank(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_ALLOW_NUMBER.getMessage());
        }
    }
}
