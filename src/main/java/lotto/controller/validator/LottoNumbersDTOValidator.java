package lotto.controller.validator;

import static lotto.domain.LottoNumbers.LOTTO_NUMBERS_SIZE_ERROR;
import static lotto.domain.LottoNumbers.MAX_LOTTO_NUMBER_SIZE;

import lotto.controller.dto.LottoNumbersDTO;

public class LottoNumbersDTOValidator {

    public static void validate(LottoNumbersDTO dto) {
        if (dto.getLottoNumbers().size() != MAX_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_ERROR);
        }
    }
}
