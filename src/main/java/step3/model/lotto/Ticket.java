package step3.model.lotto;

import java.util.List;
import java.util.stream.Collectors;
import step3.model.machine.Result;
import step3.model.util.InputValidation;

public class Ticket {
    private final List<LottoNumber> ticket;
    public Ticket(List<Integer> ticket){
        InputValidation.validateTicketLength(ticket);
        this.ticket = ticket.stream().map(LottoNumber::new).collect(Collectors.toList());
    }
    public Result getResult(Lotto lotto){
        int count = (int) ticket.stream().filter(number -> lotto.isMatched(number)).count();
        return Result.getMatchResult(count);
    }


    @Override
    public String toString() {
        return ticket.stream().map(LottoNumber::toString).collect(Collectors.toList()).toString();
    }
}
