package by.volodko.epam.composite_chain.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Symbol implements TextComponent {
    static final Logger logger = LogManager.getLogger();
    static final String UNSUPPORTED_OPERATION_MESSAGE = "Unsupported operation with symbol";
    private ComponentType componentType;
    private char symbol;


    public Symbol() {
    }

    public Symbol(ComponentType componentType, char symbol) {
        this.componentType = componentType;
        this.symbol = symbol;
    }


    @Override
    public void add(TextComponent textComponent) {
        logger.log(Level.ERROR, UNSUPPORTED_OPERATION_MESSAGE);
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    @Override
    public void remove(TextComponent textComponent) {
        logger.log(Level.ERROR, UNSUPPORTED_OPERATION_MESSAGE);
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getChildren() {
        logger.log(Level.ERROR, UNSUPPORTED_OPERATION_MESSAGE);
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol1 = (Symbol) o;

        if (symbol != symbol1.symbol) return false;
        return componentType == symbol1.componentType;
    }

    @Override
    public int hashCode() {
        int result = componentType != null ? componentType.hashCode() : 0;
        result = 31 * result + (int) symbol;
        return result;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
