package domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Integer> numbers;

    public Numbers(String[] strNumbers){
        List<Integer> numbers = new ArrayList<>();
        for (String strNumber : strNumbers) {
            numbers.add(parseInt(strNumber));
        }
        this.numbers = numbers;
    }

    public int parseInt(String strNumber){
        int number = 0;
        try{
            number = Integer.parseInt(strNumber);
            isValidNumberRange(number);
        }catch (NumberFormatException e){
            throw new RuntimeException("숫자만 입력 가능 합니다.");
        }
        return number;
    }
    public void isValidNumberRange(int number){
        if( number < 0){
            throw new RuntimeException("입력받은 숫자 값이 음수 입니다");
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
