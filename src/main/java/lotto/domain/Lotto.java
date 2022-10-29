package lotto.domain;

import java.util.*;

public class Lotto {

    private final List<Integer> lottoNumbers;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final int SUBLIST_START_IDX = 0;
    private static final int SUBLIST_END_IDX = 6;

    public Lotto(){
        lottoNumbers = generateUniqueLottoNumbers();
    }

    public Lotto(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public int countCollectNumber(List<Integer> winningNumbers) {
        int result = 0;
        for(int winningNumber : winningNumbers){
            if(lottoNumbers.contains(winningNumber)){
                result++;
            }
        }
        return result;
    }

    public List<Integer> generateUniqueLottoNumbers(){
        List<Integer> lottoRange = new ArrayList<>();
        for(int i=MIN_LOTTO_NUMBER; i<=MAX_LOTTO_NUMBER; i++){
            lottoRange.add(i);
        }
        Collections.shuffle(lottoRange);
        List<Integer> lottoNumbers = lottoRange.subList(SUBLIST_START_IDX, SUBLIST_END_IDX);
        lottoNumbers.sort(Comparator.comparingInt(i -> i));
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
