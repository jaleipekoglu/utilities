package com.csvparser;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CsvParserTest {

    CsvParser csvParser;

    List<String[]> lines;

    @Before
    public void setUp() throws Exception {
        csvParser = new CsvParser();
        lines = csvParser.readAll("students.csv");
    }

    @Test
    public void whenReadOneLineThenAnswerWithTrue() throws IOException {
        assertTrue(lines.get(1)[0].equals("John Smith") && lines.get(1)[1].trim().equals("823432"));
    }

    @Test
    public void whenReadAllLinesThenReturnTrue() {
        assertEquals(lines.size(), 3);
    }
}
