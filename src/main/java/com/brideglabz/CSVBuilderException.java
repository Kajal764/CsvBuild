package com.brideglabz;

public class CSVBuilderException extends Exception {

    public enum ExceptionType {
        CENSUS_FILE_PROBLEM, UNABLE_TO_PARSE,
    }

    public ExceptionType type;

    public CSVBuilderException(String message, CSVBuilderException.ExceptionType unableToParse) {
    super(message);
    this.type=type;


    }


}
