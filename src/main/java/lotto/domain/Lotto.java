package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumber;

    public Lotto() {
        this.lottoNumber = this.makeLottoNumber();
    }
    
    public int getSize() {
        return this.lottoNumber.size();
    }
    
    public List<Integer> makeLottoNumber() {
        List<Integer> numberRange = new ArrayList<Integer>();
        for (int i = 1; i <= 45; i++) {
            numberRange.add(i);
        }
        Collections.shuffle(numberRange);
        List<Integer> lottoNumber = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            lottoNumber.add(i);
        }
        Collections.sort(lottoNumber);
        return lottoNumber;
        
    }

}
