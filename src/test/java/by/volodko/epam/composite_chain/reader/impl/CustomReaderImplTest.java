package by.volodko.epam.composite_chain.reader.impl;

import by.volodko.epam.composite_chain.exception.CompositeException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomReaderImplTest {
    private CustomReaderImpl reader;
    @BeforeClass
    public void init(){
        reader = new CustomReaderImpl();
    }

    @Test
    public void readText () throws CompositeException {
        String text = reader.read( "src\\main\\resources\\data\\text.txt");

        Assert.assertFalse(text.isEmpty());
    }

}