package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> lottoNumbers;
    private int matchCount = 0;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
   
    
    public Lotto() {
        List<Integer> lottoRange = convertList(getLottoRange());
        Collections.shuffle(lottoRange);
        this.lottoNumbers = lottoRange.subList(0,LOTTO_NUMBER_COUNT);
        Collections.sort(this.lottoNumbers);
    }
    
    private IntStream getLottoRange(){
        return IntStream.range(LOTTO_NUMBER_START, LOTTO_NUMBER_END);
    }
    
    private List<Integer> convertList(IntStream lottoRange){
        return lottoRange.boxed().collect(Collectors.toList());
    }
    
    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }
    
    
    public void compareCountUp(int winningNumber) {
        if(lottoNumbers.contains(winningNumber)){
            matchCount++;
        }
    }
    
    public int getMatchCount() {
        return this.matchCount;
    }
    
    public void compareMath(ArrayList<Integer> winningNumbers) {
        for (int winningNumber: winningNumbers) {
            compareCountUp(winningNumber);
        }
    }
}
