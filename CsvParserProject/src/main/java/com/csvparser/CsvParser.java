package com.csvparser;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {


    public List<String[]> readAll(String fileName) throws IOException {

        List<String[]> csvData = new ArrayList<>();

        try (Reader reader = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileName));
            CSVReader csvReader = new CSVReader(reader)) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                csvData.add(nextRecord);
            }

        }
        return csvData;
    }

    public <T> List<T> beanBuilder(Class<T> clazz, String fileName) throws IOException {

        List<T> t = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                this.getClass().getClassLoader().getResourceAsStream(fileName)))) {

            HeaderColumnNameMappingStrategy<T> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(clazz);

            CsvToBean csvToBean = new CsvToBeanBuilder(br)
                    .withType(clazz)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            t = csvToBean.parse();

        }
        return t;
    }
}
