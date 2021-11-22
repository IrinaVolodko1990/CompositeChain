package by.volodko.epam.composite_chain.parser.impl;

import by.volodko.epam.composite_chain.entity.TextComponent;
import by.volodko.epam.composite_chain.entity.TextComposite;
import by.volodko.epam.composite_chain.exception.CompositeException;
import by.volodko.epam.composite_chain.parser.TextParser;
import by.volodko.epam.composite_chain.reader.impl.CustomReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParagraphParserTest {
   @BeforeClass
   public void init() throws CompositeException {
       CustomReaderImpl reader = new CustomReaderImpl();
       String text = reader.read("src\\main\\resources\\data\\text.txt");
   }
    @Test
    public void paragraphParser (TextComponent paragraph){

    }

}