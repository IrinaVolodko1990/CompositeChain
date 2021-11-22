package by.volodko.epam.composite_chain.parser.impl;

import by.volodko.epam.composite_chain.entity.ComponentType;
import by.volodko.epam.composite_chain.entity.TextComponent;
import by.volodko.epam.composite_chain.entity.TextComposite;
import by.volodko.epam.composite_chain.parser.TextParser;

public class ExpressionParser implements TextParser {
    private final TextParser letterParser = new LetterParser();

    @Override
    public TextComposite parse(String expression) {
        TextComposite expressionComposite = new TextComposite(ComponentType.EXPRESSION);
        TextComponent expressionComponent = letterParser.parse(expression);
        expressionComposite.add(expressionComponent);
        return expressionComposite;
    }
}
