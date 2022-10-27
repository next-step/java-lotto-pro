package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> lottoNumbers;
    private int matchCount;
    
    public Lotto(ArrayList<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
    
    
    public void matchCountUp(int winningNumber) {
        if(match(winningNumber)){
            matchCount++;
        }
    }
    
    public int getMatchCount() {
        return this.matchCount;
    }
    
    public void compareMath(ArrayList<Integer> winningNumbers) {
        for (int winningNumber: winningNumbers) {
            matchCountUp(winningNumber);
        }
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
