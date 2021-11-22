package by.volodko.epam.composite_chain.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> textComponents = new ArrayList<>();
    private ComponentType componentType;

    public TextComposite() {
    }

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public void add(TextComponent textComponent) {
        textComponents.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
        textComponents.remove(textComponent);
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getChildren() {
        return List.copyOf(textComponents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (textComponents != null ? !textComponents.equals(that.textComponents) : that.textComponents != null)
            return false;
        return componentType == that.componentType;
    }

    @Override
    public int hashCode() {
        int result = textComponents != null ? textComponents.hashCode() : 0;
        result = 31 * result + (componentType != null ? componentType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        String delimeter = componentType.getDelimeter();
        for (TextComponent textComponent : textComponents) {
            sb.append(textComponent.toString()).append(delimeter);
        }

        return sb.toString();
    }
}


