package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.util.Constants;

public class LottoMachine{
    private static final String ERR_BUY_MORE_THAN_MONEY = "소지금이 부족합니다.";
    
    private List<Lotto> myLottos;
    private Money insertedMoney;
    
    public LottoMachine(Money money) {
        this.myLottos = new ArrayList<>();
        this.insertedMoney = money;
    }
    
    public int buyLottoAuto(int manualCount){
        int autoBuyCount = this.insertedMoney.getBuyCount() - manualCount;
        
        if(autoBuyCount < 0) {
            throw new IllegalArgumentException(ERR_BUY_MORE_THAN_MONEY);
        }
        
        IntStream.range(0, autoBuyCount).forEach(i -> {
            myLottos.add(new Lotto(Constants.AUTO_TICKET_KEY));
        });
        
        return autoBuyCount;
    }
    
    public void buyLottoManual(String lottoNumbers) {
        myLottos.add(new Lotto(lottoNumbers));
    }
    
    public String getLottoList() {
        return this.myLottos.toString();
    }
    
    public Result getResult(Lotto winningTicket) {
        Result result = new Result();
        
        for (Lotto l : this.myLottos) {
            int countOfMatch = l.getCountOfMatch(winningTicket);
            boolean matchBonus = l.getMatchBonus(winningTicket);
            result.checkPrizeMoney(countOfMatch, matchBonus);
        }
        
        result.checkResultRate(insertedMoney);
        
        return result;
    }  
}
