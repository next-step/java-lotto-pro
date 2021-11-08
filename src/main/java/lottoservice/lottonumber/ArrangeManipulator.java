package lottoservice.lottonumber;

import java.util.List;

public interface ArrangeManipulator {

	<T> void shuffleElements(List<T> elements);

	<T> List<T> getRandomElements(List<T> elements, int sizeOfPick);
}
