package study.lotto;

public class LottoMoney {
    static final int LOTTO_TICKET_PRICE = 1000;
    private final int amount;

    public LottoMoney(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public LottoMoney(String amount) {
        this(Integer.parseInt(amount));
    }

    private void validate(int amount) {
        if (amount < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("구매금액이 로또 티켓 값보다 작습니다.");
        }
    }

    public int maxLottoTicketCount() {
        return amount / LOTTO_TICKET_PRICE;
    }

    public static int countAmount(int ticketCount) {
        return ticketCount * LOTTO_TICKET_PRICE;
    }
}
