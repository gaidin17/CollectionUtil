package utils;

import java.util.*;

/**
 * Created by Evgeny_Akulenko on 5/26/2016.
 */
public class CollectionUtil {
    public <T> T findMax(List<? extends T> list, Comparator<? super T> comparator) {
        T max = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        max = list.get(0);
        for (T elem : list) {
            if (comparator.compare(max, elem) < 0) {
                max = elem;
            }
        }
        return max;
    }
}

