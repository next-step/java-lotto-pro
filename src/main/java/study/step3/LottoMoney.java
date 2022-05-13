package study.step3;

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
            throw new IllegalArgumentException("");
        }
    }

    public int maxLottoTicketCount() {
        return amount / LOTTO_TICKET_PRICE;
    }
}
