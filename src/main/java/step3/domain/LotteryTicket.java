package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryTicket {
    private final List<Lotto> lotteryTicket = new ArrayList<>();
    private final Payment payment;
    
    public LotteryTicket(int payment) {
        this.payment = new Payment(payment);
    }
    
    public List<Lotto> getLotteryTicket() {
        return this.lotteryTicket;
    }
    
    public void add(Lotto lotto) {
        this.lotteryTicket.add(lotto);
    }
    
    public Payment getPayment() {
        return this.payment;
    }

}
