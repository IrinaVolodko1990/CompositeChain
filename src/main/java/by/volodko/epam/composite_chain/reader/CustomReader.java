package by.volodko.epam.composite_chain.reader;

import by.volodko.epam.composite_chain.exception.CompositeException;

public interface CustomReader {
    String read (String fileName) throws CompositeException;
}
