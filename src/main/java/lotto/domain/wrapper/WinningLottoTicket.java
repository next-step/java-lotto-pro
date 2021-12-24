package lotto.domain.wrapper;

public class WinningLottoTicket {
	private static final String MESSAGE_WRONG_BONUS_NUMBER = "보너스 볼을 다시 입력해 주세요.";

	private final LottoTicket ticket;
	private final LottoNumber bonus;

	public WinningLottoTicket(LottoTicket ticket, LottoNumber bonus) {
		this.ticket = ticket;
		this.bonus = validatedBonus(ticket, bonus);
	}

	private LottoNumber validatedBonus(LottoTicket ticket, LottoNumber bonus) {
		try {
			return validatedBonusNumber(ticket, bonus);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MESSAGE_WRONG_BONUS_NUMBER);
		}
	}

	private LottoNumber validatedBonusNumber(LottoTicket ticket, LottoNumber bonus) {
		if (!LottoTicket.getDefaultNumbers().contains(bonus) || ticket.getNumbers().contains(bonus)) {
			throw new IllegalArgumentException(MESSAGE_WRONG_BONUS_NUMBER);
		}
		return bonus;
	}

	public boolean hasBonusWithin(LottoTicket undisclosedTicket) {
		return undisclosedTicket.getNumbers().contains(this.bonus);
	}

	public LottoTicket getTicket() {
		return this.ticket;
	}

	public LottoNumber getBonus() {
		return this.bonus;
	}
}
