package by.volodko.epam.composite_chain.service.impl;

import by.volodko.epam.composite_chain.entity.ComponentType;
import by.volodko.epam.composite_chain.entity.TextComponent;
import by.volodko.epam.composite_chain.entity.TextComposite;
import by.volodko.epam.composite_chain.service.TextAction;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextActionImpl implements TextAction {
    private static final String VOWEL_REGEX = "(?i)(?u)[aeiouyаеиоуыэ-я]";
    private static final String CONSONANT_REGEX = "(?i)(?u)[\\p{Alpha}б-ь&&[^aeiouyеиоуы]]";

    @Override
    public List<TextComponent> sortParagraphsBySentenceQuantity(TextComposite textComposite) {
        List<TextComponent> sortedParagraphs = textComposite.getChildren();
        sortedParagraphs.sort(new Comparator<TextComponent>() {
            @Override
            public int compare(TextComponent o1, TextComponent o2) {
                Integer sizeO1 = o1.getChildren().size();
                Integer sizeO2 = o2.getChildren().size();
                return sizeO1.compareTo(sizeO2);


            }
        });
        return sortedParagraphs;
    }

    @Override
    public List<TextComponent> findSentenceWithLongestWord(TextComposite textComposite) {
        int maxLenght = longestWordLenght(textComposite);
        return textComposite.getChildren().stream()
                .flatMap(p -> p.getChildren().stream())
                .flatMap(s -> s.getChildren().stream())
                .filter(l -> l.getChildren().stream()
                        .anyMatch(w -> w.getType().equals(ComponentType.WORD) && w.toString().length() == maxLenght))
                .collect(Collectors.toList());
    }

    private int longestWordLenght(TextComposite textComposite) {
        TextComponent textComponent = textComposite.getChildren().stream()
                .flatMap(p -> p.getChildren().stream())
                .flatMap(s -> s.getChildren().stream())
                .flatMap(l -> l.getChildren().stream())
                .filter(w -> w.getType().equals(ComponentType.WORD))
                .max(Comparator.comparingInt(w -> w.toString().length()))
                .get();
        return textComponent.toString().length();
    }

    @Override
    public List<TextComponent> removeSentence(TextComposite textComposite, int wordsQuantity) {
        return textComposite.getChildren().stream()
                .flatMap(p -> p.getChildren().stream())
                .filter(s -> s.getChildren().stream()
                        .flatMap(l -> l.getChildren().stream())
                        .filter(w -> w.getType().equals(ComponentType.WORD)).count()
                        >= wordsQuantity).collect(Collectors.toList());
    }

    @Override
    public Map<String, Long> sameWordsSum(TextComposite textComposite) {
       Map <String,Long> sameWords = textComposite.getChildren().stream()
               .flatMap(p->p.getChildren().stream())
               .flatMap(s->s.getChildren().stream())
               .flatMap(l->l.getChildren().stream())
               .filter(w->w.getType().equals(ComponentType.WORD))
               .collect(Collectors.groupingBy(w->w.toString().toLowerCase(), Collectors.counting()));

       sameWords.entrySet().removeIf(w->w.getValue()==1);

        return sameWords;
    }

    @Override
    public long sumConsonants(TextComponent sentenceComponent) {
        return sentenceComponent.getChildren().stream()
                .flatMap(l->l.getChildren().stream())
                .filter(w->w.getType().equals(ComponentType.WORD))
                .flatMap(w->w.getChildren().stream())
                .flatMap(l->l.getChildren().stream())
                .filter(l->l.toString().matches(CONSONANT_REGEX))
                .count();
    }

    @Override
    public long sumVowels(TextComponent sentenceComponent) {
        return sentenceComponent.getChildren().stream()
                .flatMap(l->l.getChildren().stream())
                .filter(w->w.getType().equals(ComponentType.WORD))
                .flatMap(w->w.getChildren().stream())
                .flatMap(l->l.getChildren().stream())
                .filter(l->l.toString().matches(VOWEL_REGEX))
                .count();
    }
}
