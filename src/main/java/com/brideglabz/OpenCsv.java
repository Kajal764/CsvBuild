package com.brideglabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class OpenCsv<E> implements ICSVBuilder
{
    public  Iterator<E> getCSVIterator(Reader reader, Class csvClass) throws CSVBuilderException {
        return this.getCSvToBean(reader,csvClass).iterator();


    }

    public List getCSVFileList(Reader reader,Class CSVClass) throws CSVBuilderException{
        return this.getCSvToBean(reader,CSVClass).parse() ;
    }

    public CsvToBean<E> getCSvToBean(Reader reader, Class csvClass)throws CSVBuilderException
    {
        try{
            CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<E> csvToBean = csvToBeanBuilder.build();
            return csvToBean;
        }
        catch (IllegalStateException e) {

            throw new CSVBuilderException(e.getMessage(),
                    CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }

    }


}
