package step2;

public class StringValidation {
    private String inputValue;

    public StringValidation(String inputValue) {
        this.inputValue = inputValue;
    }

    public void isNullOrEmptyByThrow() {
        if(inputValue == null || inputValue.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void isNegativeByThrow() {
        int length = inputValue.length();
        String inputValueReplace = inputValue.replaceAll("-", "");
        if(length != inputValueReplace.length()) {
            throw new NotNegativeException("음수를 입력하면 안됩니다.");
        }
    }
}
