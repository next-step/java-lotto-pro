package lottoservice.lottonumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoArrangeManipulator implements ArrangeManipulator {

	@Override
	public <LottoNumber> void shuffleElements(List<LottoNumber> elements) {
		Collections.shuffle(elements);
	}

	@Override
	public <LottoNumber> List<LottoNumber> getRandomElements(List<LottoNumber> elements, int sizeOfPick) {
		shuffleElements(elements);
		return new ArrayList<>(elements.subList(0,	sizeOfPick));
	}
}
