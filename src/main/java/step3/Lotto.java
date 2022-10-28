package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final static String NUMBER_DELIMITER = ", ";
    private final List<Integer> lottoNumbers;
    private int matchCount;
    
    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
    
    
    public void matchCountUp(int winningNumber) {
        if(match(winningNumber)){
            this.matchCount++;
        }
    }
    
    public int getMatchCount() {
        return this.matchCount;
    }
    
    public int compareMath(ArrayList<Integer> winningNumbers) {
        this.matchCount = 0;
        for (int winningNumber: winningNumbers) {
            matchCountUp(winningNumber);
        }
        return this.matchCount;
    }
    
    public String numberToString() {
        return lottoNumbers.stream().map(String::valueOf).collect(Collectors.joining(NUMBER_DELIMITER));
    }
    
    public boolean match(int winningNumber) {
        return this.lottoNumbers.contains(winningNumber);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return matchCount == lotto.matchCount && Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, matchCount);
    }

}
