package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import view.Printable;

public class LottoTickets implements Printable {
    private List<LottoTicket> lottoTicketList;

    private static final String NEW_LINE = "\n";

    public LottoTickets(int count) {
        lottoTicketList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoTicketList.add(new LottoTicket());
        }
    }

    public int getSize() {
        return lottoTicketList.size();
    }

    @Override
    public String makePrintableMessage() {
        return lottoTicketList.stream().map(LottoTicket::makePrintableMessage).collect(Collectors.joining(NEW_LINE));
    }
}
