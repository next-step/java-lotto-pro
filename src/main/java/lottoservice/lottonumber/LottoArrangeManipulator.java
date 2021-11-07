package lottoservice.lottonumber;

import java.util.Collections;
import java.util.List;

public class LottoArrangeManipulator implements ArrangeManipulator {

	@Override
	public <LottoNumber> void shuffleElements(List<LottoNumber> elements) {
		Collections.shuffle(elements);
	}
}
