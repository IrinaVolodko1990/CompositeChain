package by.volodko.epam.composite_chain.parser.impl;

import by.volodko.epam.composite_chain.entity.ComponentType;
import by.volodko.epam.composite_chain.entity.TextComponent;
import by.volodko.epam.composite_chain.entity.TextComposite;
import by.volodko.epam.composite_chain.parser.TextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class SentenceParser implements TextParser {
    private static final String SENTENCE_DELIMITER_REGEX = ".+?[.?!…](?=\\s|$)";;
    private final TextParser lexemeParser = new LexemeParser();

    @Override
    public TextComposite parse(String paragraph) {
        TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);
        Pattern sentencePattern = Pattern.compile(SENTENCE_DELIMITER_REGEX);
        Matcher sentences = sentencePattern.matcher(paragraph);
        while (sentences.find()) {
            TextComponent sentenceComponent = lexemeParser.parse(sentences.group());
            paragraphComposite.add(sentenceComponent);
        }
        return paragraphComposite;
    }

}



