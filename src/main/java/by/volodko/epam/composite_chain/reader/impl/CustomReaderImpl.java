package by.volodko.epam.composite_chain.reader.impl;

import by.volodko.epam.composite_chain.exception.CompositeException;
import by.volodko.epam.composite_chain.reader.CustomReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CustomReaderImpl implements CustomReader {
    static final Logger logger = LogManager.getLogger();

    @Override
    public String read(String fileName) throws CompositeException {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)){
            logger.log(Level.ERROR, "File " + fileName+" not found");
            throw  new CompositeException("File " + fileName+" not found");
        }

        String text;
        try{
            text= Files.readString(path);
        }catch (IOException e ){
            logger.log(Level.ERROR,"IO exception: " +e );
            throw new CompositeException("IO exception: ", e );
        }
        return text;
    }
}

