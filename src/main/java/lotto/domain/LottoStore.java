package lotto.domain;

public final class LottoStore {

    private final Money ticketFee;
    private final LottoNumbersSupplier lottoNumbersSupplier;

    public LottoStore(final Money ticketFee, final LottoNumbersSupplier lottoNumbersSupplier) {
        this.ticketFee = ticketFee;
        this.lottoNumbersSupplier = lottoNumbersSupplier;
    }

    public void sellAllTo(final LottoCustomer customer) {
        LottoTicket ticket = createLottoTicket();
        while (customer.canPurchase(ticket)) {
            customer.purchase(ticket);
            ticket = createLottoTicket();
        }
    }

    private LottoTicket createLottoTicket() {
        return new LottoTicket(ticketFee, lottoNumbersSupplier.get());
    }

}
