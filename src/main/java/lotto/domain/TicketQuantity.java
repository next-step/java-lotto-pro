package lotto.domain;

public class TicketQuantity {
    private static final int MIN_TICKET_QUANTITY = 0;
    private static final String ERROR_MSG_NOT_NUMBER = "티켓 수량은 숫자로만 입력해 주세요.";
    private static final String ERROR_MSG_NUMBER_RANGE = "티켓 수량은 %d개 이상 %d개 이하 구매 가능합니다.";
    private final int ticketQuantity;

    public TicketQuantity(String ticketQuantity, int maxQuantity) {
        validateNumber(ticketQuantity);
        validateRange(Integer.parseInt(ticketQuantity), maxQuantity);
        this.ticketQuantity = Integer.parseInt(ticketQuantity);
    }

    public int getTicketQuantity() {
        return this.ticketQuantity;
    }

    public boolean isEmpty() {
        return this.ticketQuantity > MIN_TICKET_QUANTITY;
    }

    private void validateNumber(String ticketQuantity) {
        try {
            Integer.parseInt(ticketQuantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MSG_NOT_NUMBER);
        }
    }

    private void validateRange(int ticketQuantity, int maxQuantity) {
        if (ticketQuantity < MIN_TICKET_QUANTITY || ticketQuantity > maxQuantity) {
            throw new IllegalArgumentException(String.format(ERROR_MSG_NUMBER_RANGE, MIN_TICKET_QUANTITY, maxQuantity));
        }
    }
}
