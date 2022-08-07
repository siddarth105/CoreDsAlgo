package Pbm.Halodoc;

public class Attribute<T> {

    private String attributeName;
    private T attribute;

    public Attribute(String attributeName, T attribute) {
        this.attributeName = attributeName;
        this.attribute = attribute;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public T getAttribute() {
        return attribute;
    }
}
