package step3.view.input;

public class InputWinningLottoNumbers implements Input<String> {

    @Override
    public String create() {
        String input = scanner.nextLine();
        validateBlank(input);
        return input;
    }
}
