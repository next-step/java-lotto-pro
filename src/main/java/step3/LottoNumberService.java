package step3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberService {
	private final static String SPACE = "\\s+";
	public List<LottoNumber> convertLottoNumber(String userInputWinnerNumber) {
		final String inputNumber = userInputWinnerNumber.replaceAll(SPACE, "");
		return Arrays.stream(inputNumber.split(","))
			.map(s -> new LottoNumber(Integer.parseInt(s))).collect(Collectors.toList());
	}
}
