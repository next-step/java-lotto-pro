package lotto.domain;

import lotto.util.Validator;

public class BonusNum {
    public final int num;
    
    public BonusNum(String bonusNumStr) {
        this.num = validateBonusNum(bonusNumStr);
    }
    
    private int validateBonusNum(String bonusNumStr) {
        Validator.validateIsNull(bonusNumStr);
        Validator.validateLottoNumberBoundary(bonusNumStr);

        int bonusNum = Integer.parseInt(bonusNumStr);
        
        return bonusNum;
    }
}
