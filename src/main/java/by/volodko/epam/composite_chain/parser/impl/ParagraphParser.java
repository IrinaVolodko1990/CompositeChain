package by.volodko.epam.composite_chain.parser.impl;

import by.volodko.epam.composite_chain.entity.ComponentType;
import by.volodko.epam.composite_chain.entity.TextComponent;
import by.volodko.epam.composite_chain.entity.TextComposite;
import by.volodko.epam.composite_chain.parser.TextParser;




public class ParagraphParser implements TextParser {
    private static final String PARAGRAPH_DELIMITER_REGEX =  "(^\\s{4}|t)";
    private final TextParser sentenceParser = new SentenceParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite textComposite = new TextComposite(ComponentType.TEXT);
        String[] paragraphs = text.split(PARAGRAPH_DELIMITER_REGEX);
        TextComposite paragraphComposite = new TextComposite (ComponentType.PARAGRAPH);
        for (String paragraph: paragraphs){
            TextComponent paragraphComponent = sentenceParser.parse(paragraph);
            textComposite.add(paragraphComponent);
        }
        return textComposite;
    }
}
