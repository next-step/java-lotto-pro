package step3.view.input;

import java.util.Optional;

public class InputWinningLottoNumbers implements Input<Optional<String>> {

    @Override
    public Optional<String> create() {
        String input = scanner.nextLine();
        validateBlank(input);
        return Optional.of(input);
    }
}
