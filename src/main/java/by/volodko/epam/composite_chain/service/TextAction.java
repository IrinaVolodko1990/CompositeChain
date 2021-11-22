package by.volodko.epam.composite_chain.service;

import by.volodko.epam.composite_chain.entity.TextComponent;
import by.volodko.epam.composite_chain.entity.TextComposite;

import java.util.List;
import java.util.Map;

public interface TextAction {
    List<TextComponent> sortParagraphsBySentenceQuantity(TextComposite textComposite);
    List<TextComponent> findSentenceWithLongestWord (TextComposite textComposite);
    List<TextComponent> removeSentence (TextComposite textComposite, int wordsQuantity);
    Map <String,Long> sameWordsSum(TextComposite textComposite);
    long sumConsonants(TextComponent sentenceComponent);
    long sumVowels (TextComponent sentenceComponent);


}
