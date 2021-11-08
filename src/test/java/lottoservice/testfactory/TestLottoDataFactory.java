package lottoservice.testfactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottoticket.LottoTicket;

public class TestLottoDataFactory {
	public static List<Integer> getNumbers(int... numbers){
		return Arrays.stream(numbers).boxed().collect(Collectors.toList());
	}

	public static List<LottoNumber> getLottoNumbers(int... numbers){
		return Arrays.stream(numbers).mapToObj(it -> LottoNumber.valueOf(it)).collect(Collectors.toList());
	}

	public static LottoTicket getLottoTicket(int... numbers){
		return new LottoTicket(getLottoNumbers(numbers));
	}
}
