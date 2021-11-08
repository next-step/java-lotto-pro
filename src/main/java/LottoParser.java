import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {

	private static final String DELIMITER = ",";

	public static List<LottoNumber> parse(String s) {
		validate(s);
		final String[] tokens = s.split(DELIMITER);
		validate(tokens.length);
		return Arrays.stream(tokens)
			.map(String::trim)
			.mapToInt(LottoParser::parseInt)
			.mapToObj(LottoNumber::from)
			.collect(Collectors.toList());
	}

	private static void validate(String s) {
		if (null == s) {
			throw new LottoFormatException();
		}
	}

	private static void validate(int numOfLottoNumbers) {
		if (numOfLottoNumbers != Lotto.NUM_OF_LOTTO_NUMBERS) {
			throw new LottoFormatException();
		}
	}

	private static int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new LottoNumberFormatException();
		}
	}
}
