package lottoservice.matcher;

import java.util.Objects;

import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottoticket.LottoTicket;

public class BonusNumber {

	private static final String ERROR_MESSAGE_NOT_NUMBER="1~45사이 숫자를 입력해주세요.";

	LottoNumber lottoNumber;

	public BonusNumber(LottoNumber lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public BonusNumber(int number) {
		this.lottoNumber = LottoNumber.valueOf(number);
	}

	public BonusNumber(String numberText) {
		int number = parseToInteger(numberText);
		this.lottoNumber = LottoNumber.valueOf(number);
	}

	private int parseToInteger(String numberText) {
		try {
			return Integer.parseInt(numberText);
		} catch (NumberFormatException ex) {
			throw new InvalidLottoFormatException(ERROR_MESSAGE_NOT_NUMBER);
		}
	}

	public LottoNumber getLottoNumber() {
		return lottoNumber;
	}

	protected boolean isMatchNumber(LottoNumber comparingLottoNumber){
		return this.lottoNumber.equals(comparingLottoNumber);
	}

	protected boolean matchTicket(LottoTicket lottoTicket) {
		return lottoTicket.hasLottoNumber(getLottoNumber());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BonusNumber that = (BonusNumber)o;
		return lottoNumber.equals(that.getLottoNumber());
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}
}
