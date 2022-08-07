package Pbm.Halodoc;

import java.util.List;

public interface Keystore {

    void insert(String key, List<Attribute> attrList);
    String getRevSearch(String key, String value);
    Object search(String key);
}
