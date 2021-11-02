package calculator.domain;

public class Number {
    private int number;

    public Number(String input){
        validation(input);
        this.number = Integer.parseInt(input);
    }

    private void validation(String input){
        if(!input.chars().allMatch(Character::isDigit)){
            throw new RuntimeException("숫자만 입력할 수 있습니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
