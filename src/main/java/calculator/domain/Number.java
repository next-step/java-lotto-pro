package calculator.domain;

public class Number {
    private int number;

    public Number(String input){
        this.number = parsing(input);
    }

    private void validation(String input){
        if(!input.chars().allMatch(Character::isDigit)){
            throw new RuntimeException("숫자만 입력할 수 있습니다.");
        }
    }

    private int parsing(String input){
        if(input == null || input.trim().isEmpty()) return 0;
        validation(input);
        return Integer.parseInt(input);
    }

    public int getNumber() {
        return number;
    }
}
