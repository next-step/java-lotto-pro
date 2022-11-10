package lotto.domain;

import lotto.util.IntUtil;
import lotto.util.Validator;

public class LottoNumber {
    public final int num;
    
    public LottoNumber(int i) {
        this.num = generateNumber(i);
    }
    
    public LottoNumber(String str) {
        this.num = generateNumber(str);
    }
    
    private int generateNumber(String str) {
        Validator.validateIsEmpty(str);
        Validator.validateLottoNumberBoundary(str);

        int i = IntUtil.parseInt(str);
        
        return i;
    }
    
    private int generateNumber(int i) {
        Validator.validateLottoNumberBoundary(i);
        
        return i;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.num);
    }
    
    @Override
    public boolean equals(Object obj) {
        LottoNumber cmpLottoNumber = (LottoNumber) obj;
        
        if(cmpLottoNumber.num == this.num) {
            return true;
        }
        
        return false;
    }
}
