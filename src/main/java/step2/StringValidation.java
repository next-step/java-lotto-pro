package step2;

public class StringValidation {
    private String inputValue;

    public StringValidation(String inputValue) {
        this.inputValue = inputValue;
    }

    public void isNullOrEmptyThrow() {
        if(inputValue == null || inputValue.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
