package com.wcs.citimmo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Helpers {
    
    public static List<String> convertStringToListOfStrings(String param) {
        if (param == null) {
            return new ArrayList<String>();
        }
        return Arrays.stream(param.split(",")).collect(Collectors.toList());
    }

    public static List<Integer> convertStringToListOfIntegers(String param) {
        if (param == null) {
            return new ArrayList<Integer>();
        }
        return Arrays.stream(param.split(",")).mapToInt(num -> Integer.parseInt(num)).boxed().collect(Collectors.toList());
    }
    
    public static int getValueOrBoundOfOptional(Optional<String> param, int bound) {
        if (param.isPresent()) {
            try {
                return Integer.parseInt(param.get());
            } catch (Exception ex) {
                return bound;
            }
        } else {
            return bound;
        }
    }
    
    public static String getValueOrNullOfOptional(Optional<String> param) {
        if (param.isPresent()) {
            return param.get();
        } else {
            return null;
        }
    }
}
