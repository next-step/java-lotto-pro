package lotto.domain;

import java.util.List;
import lotto.util.Constants;

public class Lotto {
    private final List<LottoNumber> numbers;
    private LottoNumber bonusNumber;

    public Lotto(String LottoNumber) {
        this.numbers = new LottoGenerator().generate(LottoNumber);
    }
    
    public Lotto(String LottoNumber, String bonusNumber) {
        this.numbers = new LottoGenerator().generate(LottoNumber);
        this.bonusNumber = new LottoNumber(bonusNumber);
        
        if(LottoNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(Constants.ERR_DUP_NUMBERS);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (LottoNumber l : this.numbers) {
            sb.append(l.num).append(Constants.COMMA);
        }

        return sb.toString();
    }
    
    public void setBonusNum(String bonusNum) {
        this.bonusNumber = new LottoNumber(bonusNum);
    }
    
    public List<LottoNumber> getLottoNumbers(){
        return this.numbers;
    }
    
    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }
    
    public int getCountOfMatch(Lotto cmpLotto) {
        int countOfMatch = 0;
        
        for(LottoNumber n : cmpLotto.getLottoNumbers()) {
            countOfMatch += Boolean.compare(this.numbers.contains(n), false);
        }

        return countOfMatch;
    }    
    
    public boolean getMatchBonus(Lotto winningTicket) {
        return this.numbers.contains(winningTicket.getBonusNumber());
    }
}
