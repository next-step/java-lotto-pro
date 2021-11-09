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

	public static List<LottoNumber> getLottoNumbers(List<Integer> numbers){
		return numbers.stream().map(it -> LottoNumber.valueOf(it)).collect(Collectors.toList());
	}

	public static LottoTicket getLottoTicket(int... numbers){
		return new LottoTicket(getLottoNumbers(numbers));
	}

	public static LottoTicket getLottoTicket(String numberText){
		List<Integer> numbers = Arrays.stream(numberText.split(", ")).map(it->Integer.parseInt(it)).collect(Collectors.toList());
		return new LottoTicket(getLottoNumbers(numbers));
	}
}
