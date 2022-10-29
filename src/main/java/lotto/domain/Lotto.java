package lotto.domain;

import java.util.*;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(){
        lottoNumbers = generateUniqueLottoNumbers();
    }

    public Lotto(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public int countCollectNumber(List<Integer> winnerNumbers) {
        int result = 0;
        for(int winnerNumber : winnerNumbers){
            if(lottoNumbers.contains(winnerNumber)){
                result++;
            }
        }
        return result;
    }

    public List<Integer> generateUniqueLottoNumbers(){
        List<Integer> lottoRange = new ArrayList<>();
        for(int i=1; i<=45; i++){
            lottoRange.add(i);
        }
        Collections.shuffle(lottoRange);
        List<Integer> lottoNumbers = lottoRange.subList(0, 6);
        lottoRange.subList(0, 6).sort(Comparator.comparingInt(i -> i));
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
