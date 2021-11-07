package step3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberService {
	public List<LottoNumber> convertLottoNumber(String userInputWinnerNumber) {
		return Arrays.stream(userInputWinnerNumber.split(","))
			.map(String::trim)
			.map(s -> new LottoNumber(Integer.parseInt(s))).collect(Collectors.toList());
	}
}
