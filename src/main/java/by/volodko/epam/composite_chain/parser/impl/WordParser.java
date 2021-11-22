package by.volodko.epam.composite_chain.parser.impl;

import by.volodko.epam.composite_chain.entity.ComponentType;
import by.volodko.epam.composite_chain.entity.TextComponent;
import by.volodko.epam.composite_chain.entity.TextComposite;
import by.volodko.epam.composite_chain.parser.TextParser;

public class WordParser implements TextParser {
    private final TextParser letterParser = new LetterParser();

    @Override
    public TextComposite parse(String lexeme) {
        TextComposite wordComposite = new TextComposite(ComponentType.WORD);
        TextComponent wordComponent = letterParser.parse(lexeme);
        wordComposite.add(wordComponent);
        return wordComposite;
    }
}
