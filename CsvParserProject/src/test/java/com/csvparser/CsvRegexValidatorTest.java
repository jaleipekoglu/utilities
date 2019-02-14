package com.csvparser;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CsvRegexValidatorTest {

    private CsvRegexValidator validator;

    private CsvParser csvParser;

    Student student;

    @Before
    public void setUp() throws Exception {
        validator = new CsvRegexValidator();
        csvParser = new CsvParser();
        student = csvParser.beanBuilder(Student.class, "students.csv").get(0);
    }

    @Test
    public void whenStudentNameThenContainsOnlyNonDigits() throws IOException {
        assertTrue(validator.containsOnlyNonDigits(student.getName()));
    }

    @Test
    public void whenStudentNumberThenContainsOnlyDigits() throws IOException {
        assertTrue(validator.containsOnlyDigits(student.getStudentNumber().trim()));
    }
}
