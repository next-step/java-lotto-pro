package lottoservice.lottoticket;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;

/**
 * 자동으로 생성된 로또 번호 리스트를 가지는 로또 티켓 클래스
 * LottoNumber 클래스를 List 자료구조 묶음으로 다루는 일급 컬렉션
 */
public class LottoTicket {

	private List<LottoNumber> lottoNumbers;

	public LottoTicket(List<LottoNumber> lottoNumber) {
		this.lottoNumbers = lottoNumber;
	}

	public LottoTicket() {
		this(LottoNumbersMaker.makeLottoNumbers());
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	public int getNumOfNumbersInGroup() {
		return lottoNumbers.size();
	}

	@Override
	public String toString() {
		return lottoNumbers.stream()
			.map(lottoNumber -> lottoNumber.toString())
			.collect(Collectors.joining(", ", "[", "]"));
	}
}
