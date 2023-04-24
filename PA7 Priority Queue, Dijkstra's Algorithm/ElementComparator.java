package PA7;

import java.util.Comparator;

public class ElementComparator implements Comparator<Element> {

	@Override
	public int compare(Element o1, Element o2) {
		return o1.priority - o2.priority;
	}

}
