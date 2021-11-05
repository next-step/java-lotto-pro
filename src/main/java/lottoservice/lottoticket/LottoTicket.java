package lottoservice.lottoticket;

import java.util.List;
import java.util.stream.Collectors;

import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;

public class LottoTicket {

	private List<LottoNumber> lottoNumbers;

	public LottoTicket(List<LottoNumber> lottoNumber) {
		this.lottoNumbers = lottoNumber;
	}

	public LottoTicket() {
		this(LottoNumbersMaker.makelottoNumbers());
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	public int getNumOfNumbersInGroup() {
		return lottoNumbers.size();
	}

	@Override
	public String toString() {
		StringBuilder lottoTicketToStrMaker = new StringBuilder();
		lottoTicketToStrMaker.append('[');
		lottoTicketToStrMaker.append(lottoNumbers.stream()
			.map(lottoNumber -> lottoNumber.toString())
			.collect(Collectors.joining(", ")));
		lottoTicketToStrMaker.append(']');
		return lottoTicketToStrMaker.toString();
	}
}
