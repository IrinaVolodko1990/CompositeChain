package by.volodko.epam.composite_chain.service.impl;

import by.volodko.epam.composite_chain.entity.TextComponent;
import by.volodko.epam.composite_chain.entity.TextComposite;
import by.volodko.epam.composite_chain.exception.CompositeException;
import by.volodko.epam.composite_chain.parser.TextParser;
import by.volodko.epam.composite_chain.parser.impl.ParagraphParser;
import by.volodko.epam.composite_chain.reader.impl.CustomReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TextActionImplTest {
    private TextActionImpl action;
    private TextComposite composite;

    @BeforeClass
    public void init() throws CompositeException {
        action = new TextActionImpl();
        CustomReaderImpl reader = new CustomReaderImpl();
        TextParser parser = new ParagraphParser();

        String text = reader.read("src\\main\\resources\\data\\text.txt");
        composite = parser.parse(text);
    }

    @Test
    public void testSortParagraphsBySentenceQuantity() {

    }

    @Test
    public void testFindSentenceWithLongestWord() {
    int  expected = 1;
    List <TextComponent> sentence = action.findSentenceWithLongestWord(composite);
    int actual = sentence.size();
    Assert.assertEquals(actual,expected);}

    @Test
    public void testRemoveSentence() {
        int expected = 5;
        List<TextComponent> sentences = action.removeSentence(composite, 2);
        int actual = sentences.size();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testSameWordsSum() {
    }

    @Test
    public void testSumConsonants() {
    }

    @Test
    public void testSumVowels() {
    }
}