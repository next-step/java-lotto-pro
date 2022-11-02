package step3.view.input;

import java.util.Optional;

import static step3.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;

public class InputManualLottoQuantity implements Input<Optional<Integer>> {

    @Override
    public Optional<Integer> create() {
        String input = scanner.nextLine();
        validateBlank(input);
        try {
            return Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_ALLOW_NUMBER.getMessage());
        }
    }
}
