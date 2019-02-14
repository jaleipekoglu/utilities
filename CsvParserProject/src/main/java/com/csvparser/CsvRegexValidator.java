package com.csvparser;

public class CsvRegexValidator {

    private static final String ONLY_NON_DIGITS = "\\D*";

    private static final String ONLY_DIGITS = "\\d*";

    public boolean containsOnlyNonDigits (String phrase) {
        return phrase.matches(ONLY_NON_DIGITS);
    }

    public boolean containsOnlyDigits (String phrase) {
        return phrase.matches(ONLY_DIGITS);
    }

}
