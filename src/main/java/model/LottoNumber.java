package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    private final List<Integer> number;

    public LottoNumber(List<Integer> number) {
        Collections.sort(number);
        this.number = new ArrayList<>(number);
    }

    @Override
    public String toString() {
        return "" + number + "";
    }

    public int getWinNumberCount(List<Integer> winNumber) {
        return Math.toIntExact(number.stream()
                .filter(winNumber::contains)
                .count());
    }

    public List<Integer> getNumber() {
        return number;
    }

    public int getCountOfContain(List<Integer> winNumber) {
        return Math.toIntExact(winNumber.stream()
                .filter(this.number::contains)
                .count());
    }

    public boolean isMatchBonusNumber(int bonusNumber) {
        return this.number.contains(bonusNumber);
    }

    public int getCountOfContain(List<Integer> winNumber) {
        return (int) winNumber.stream()
                .filter(this.number::contains)
                .count();
    }

    public boolean isMatchBonusNumber(int bonusNumber) {
        return this.number.contains(bonusNumber);
    }
}
