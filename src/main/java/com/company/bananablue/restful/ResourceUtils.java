package com.company.bananablue.restful;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ResourceUtils {

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
