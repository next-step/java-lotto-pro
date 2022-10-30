package step3.domain;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@FunctionalInterface
public interface CreateLottoNumberPolicy {

    List<LottoNumber> create();

    class CreateShuffleLottoNumberPolicy implements CreateLottoNumberPolicy {

        private static final int LOTTO_NUMBER_COUNT = 6;

        private static final Set<LottoNumber> lottoNumbers = new HashSet<>();

        static {
            for (int i = 0; i < 45; i++) {
                lottoNumbers.add(new LottoNumber(i + 1));
            }
        }

        @Override
        public List<LottoNumber> create() {
            List<LottoNumber> lottoNumbers = new ArrayList<>(this.lottoNumbers);
            Collections.shuffle(lottoNumbers);

            return lottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(toList());
        }
    }
}
