package lotto.number;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private int number;

    public LottoNumber(String input) {
        int inputNumber;
        try{
            inputNumber = Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("LottoNumber 생성 실패");
        }
        checkInputNumber(inputNumber);
        this.number = inputNumber;
    }

    public LottoNumber(int input) {
        checkInputNumber(input);
        this.number = input;
    }

    private void checkInputNumber(int input){
        if(input < MIN_LOTTO_NUMBER || input > MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException("LottoNumber 생성 실패");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number-o.number;
    }
}
