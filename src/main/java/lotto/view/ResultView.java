package lotto.view;

import lotto.domain.LottoTickets;

public class ResultView {

	private static final String NEXT_LINE = "\n";

	public void printLottoTickets(LottoTickets lottoTickets) {
		StringBuilder ticketStringBuilder = new StringBuilder();
		appendLottoCount(lottoTickets, ticketStringBuilder);
		appendTicketNumbers(lottoTickets, ticketStringBuilder);
		System.out.println(ticketStringBuilder);
	}

	private void appendTicketNumbers(LottoTickets lottoTickets, StringBuilder ticketStringBuilder) {
		lottoTickets.getLottoTickets()
			.forEach(ticket -> {
					ticketStringBuilder.append(ticket.toString());
					ticketStringBuilder.append(NEXT_LINE);
				}
			);
	}

	private void appendLottoCount(LottoTickets lottoTickets, StringBuilder ticketStringBuilder) {
		ticketStringBuilder.append(lottoTickets.size()).append("개를 구매했습니다.");
		ticketStringBuilder.append(NEXT_LINE);
	}
}
