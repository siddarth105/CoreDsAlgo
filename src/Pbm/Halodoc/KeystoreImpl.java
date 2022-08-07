package Pbm.Halodoc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeystoreImpl implements Keystore {

    private Map<String, List<Attribute>> baseMap = new HashMap<>();
    private Map<String, Map<String, String>>  revMap = new HashMap<>();
    private Map<String, Class> attrTypeMap = new HashMap<>();

    public void insert(String key, List<Attribute> attrList) {
        //Validate
        for (Attribute attr : attrList) {
            if (attrTypeMap.containsKey(attr.getAttributeName())) {
                Class attrType = attrTypeMap.get(attr.getAttributeName());
                if(!attrType.isInstance(attr.getAttribute().getClass())) {
                    throw new RuntimeException("Invalid Data Type");
                }
            } else {
                // latitude -> java.util.String
                attrTypeMap.put(attr.getAttributeName(), attr.getAttribute().getClass());
            }

            //Add in rev map
            /*latitude
            6.0 -> jakarta*/
            Map<String, String> value = new HashMap<>();
            value.put(attr.getAttribute().toString(), key);
            revMap.put(attr.getAttributeName(), value);
        }
        baseMap.put(key, attrList);
    }

    //REV_SEARCH :: TIME_COMPLEXITY :: O(1) -> Avg Case
    public String getRevSearch(String key, String value) {
        if (revMap.containsKey(key)) {
            return revMap.get(key).get(value);
        }
        return null;
    }

    public Object search(String key) {
        return baseMap.get(key);
    }

}
