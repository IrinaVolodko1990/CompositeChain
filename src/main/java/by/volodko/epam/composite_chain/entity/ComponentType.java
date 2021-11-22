package by.volodko.epam.composite_chain.entity;

public enum ComponentType {
    TEXT ("\n"),
    PARAGRAPH("\n\t"),
    SENTENCE(""),
    LEXEME(" "),
    WORD (""),
    EXPRESSION (""),
    LETTER(""),
    SYMBOL("");
    private final String delimeter;

    ComponentType(String delimetr) {
        this.delimeter = delimetr;
    }

    public String getDelimeter(){
        return delimeter;
    }


}
