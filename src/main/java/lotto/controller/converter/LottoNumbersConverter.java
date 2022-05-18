package lotto.controller.converter;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.dto.LottoNumbersDTO;
import lotto.controller.dto.LottoTicketsDTO;
import lotto.domain.LottoNumbers;

public class LottoNumbersConverter {

    public static List<LottoNumbers> convert(LottoTicketsDTO dto) {
        List<LottoNumbersDTO> lottoTicketsDTO = dto.getLottoTickets();
        return lottoTicketsDTO.stream()
                .map(LottoNumbersDTO::getLottoNumbers)
                .map(LottoNumbers::from)
                .collect(Collectors.toList());
    }
}
