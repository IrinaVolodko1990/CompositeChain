package by.volodko.epam.composite_chain.parser.impl;

import by.volodko.epam.composite_chain.entity.ComponentType;
import by.volodko.epam.composite_chain.entity.Symbol;
import by.volodko.epam.composite_chain.entity.TextComponent;
import by.volodko.epam.composite_chain.entity.TextComposite;
import by.volodko.epam.composite_chain.parser.TextParser;

public class LetterParser implements TextParser {
    private static final String LETTER_DELIMITER_REGEX = "";

    @Override
    public TextComposite parse(String letter) {
        TextComposite letterComposite = new TextComposite(ComponentType.LETTER);
        String[] symbols = letter.split(LETTER_DELIMITER_REGEX);
        for (String symbol : symbols) {
            TextComponent letterComponent = new Symbol(
                    Character.isLetter(symbol.charAt(0)) ? ComponentType.LETTER : ComponentType.SYMBOL, symbol.charAt(0));
            letterComposite.add(letterComponent);
        }


        return letterComposite;
    }
}
