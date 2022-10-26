package step3;

import java.util.ArrayList;
import java.util.List;

public class LotteryTicket {
    private final List<Lotto> lotteryTicket;
    public LotteryTicket(int count) {
        lotteryTicket = new ArrayList<>();
        addRepeatLotto(count);
    }
    
    public List<Lotto> getLotteryTicket() {
        return this.lotteryTicket;
    }
    
    private void addLotto(){
        Lotto lotto = new Lotto();
        lotteryTicket.add(lotto);
    }
    
    private void addRepeatLotto(int count){
        for(int i = 0; i < count; i++){
            addLotto();
        }
    }
}
