package com.dong.utils;

import java.util.*;

/**
 * Map转换为URL参数
 */
public class CombinationParamsUtilsByDJ {

    private final static String EMPTY = "";
    /**
     * Returns a comparator that compares {@link Map.Entry} by key using the given
     * {@link Comparator}.
     */
    private static final Comparator<Map.Entry<String, Object>> KEY_NATURAL_COMPARATOR =
            Map.Entry.comparingByKey(Comparator.comparing(Objects::toString, Comparator.naturalOrder()));

    private static final Comparator<Map.Entry<String, Object>> KEY_REVERSE_COMPARATOR =
            Map.Entry.comparingByKey(Comparator.comparing(Objects::toString, Comparator.reverseOrder()));

    private static final Comparator<Map.Entry<String, Object>> VALUE_NATURAL_COMPARATOR =
            Map.Entry.comparingByValue(Comparator.comparing(Objects::toString, Comparator.naturalOrder()));

    private static final Comparator<Map.Entry<String, Object>> VALUE_REVERSE_COMPARATOR =
            Map.Entry.comparingByValue(Comparator.comparing(Objects::toString, Comparator.reverseOrder()));

    /**
     * Mapping to queryParams.
     *
     * @param params
     * @return
     */
    public static String mappingToQueryParams(Map<String, Object> params, SortedInfo sortedInfo) {
        if (params == null || params.isEmpty() || sortedInfo == null) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        params.entrySet().stream().sorted(sortedInfo.getComparator()).forEach(e -> combination(e, sb));
        return sb.deleteCharAt(0).toString();
    }

    /**
     * Combination entry.
     *
     * @param entry
     * @param sb
     */
    private static void combination(Map.Entry<String, Object> entry, StringBuilder sb) {
        sb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
    }

    public enum SortedInfo {

        /**
         * key升序
         */
        KEY_ASC(KEY_NATURAL_COMPARATOR),

        /**
         * key降序
         */
        KEY_DESC(KEY_REVERSE_COMPARATOR),

        /**
         * value升序
         */
        VALUE_ASC(VALUE_NATURAL_COMPARATOR),

        /**
         * value降序
         */
        VALUE_DESC(VALUE_REVERSE_COMPARATOR),

        /**
         * 加签时key顺序固定，请使用有序Map
         *
         * @see java.util.LinkedHashMap
         */
        NO_ORDER((o1, o2) -> 0),

        ;

        SortedInfo(Comparator<Map.Entry<String, Object>> comparator) {
            this.comparator = comparator;
        }

        private final Comparator<Map.Entry<String, Object>> comparator;

        public Comparator<Map.Entry<String, Object>> getComparator() {
            return comparator;
        }

    }
}
