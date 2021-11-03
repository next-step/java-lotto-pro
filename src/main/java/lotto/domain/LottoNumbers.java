package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;

import lotto.generator.NumberGenerator;
import lotto.utils.LottoNumberMapper;
import lotto.utils.LottoNumberValidator;

public class LottoNumbers {
	private final List<LottoNumber> lottoNumbers;

	private LottoNumbers(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoNumbers createBy(NumberGenerator numberGenerator) {
		List<LottoNumber> lottoNumbers = LottoNumberMapper.mapToLottoNumbers(numberGenerator.generate());
		LottoNumberValidator.validateLottoNumbers(lottoNumbers);

		return new LottoNumbers(lottoNumbers);
	}

	public int getSize() {
		return this.lottoNumbers.size();
	}

	public List<LottoNumber> getValues() {
		return this.lottoNumbers;
	}

	@Override
	public String toString() {
		return this.lottoNumbers.stream()
								.map(LottoNumber::getNumber)
								.collect(toList())
								.toString();
	}
}
