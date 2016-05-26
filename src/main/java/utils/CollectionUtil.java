package utils;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 5/26/2016.
 */
public class CollectionUtil {
    public <T> T findMax(List<? extends T> list, Comparator<? super T> comparator) {
        T max = null;
        if (list != null) {
            if (list.size() != 0) {
                max = list.get(0);
                for (T elem : list) {
                    if (comparator.compare(max, elem) < 0) {
                        max = elem;
                    }
                }
            }
        }
        return max;
    }
}
