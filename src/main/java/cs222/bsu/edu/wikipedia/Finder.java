package cs222.bsu.edu.wikipedia;


import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.TypeRef;

import java.util.List;


public class Finder {
    public List<search> getSearchFromJson(String json) {
        Configuration configuration = new Configuration();
        configuration.config();

        TypeRef<List<search>> typeRef = new TypeRef<>() {};

        return JsonPath.parse(json).read("$..search[:6]", typeRef);

    }
    public List<Revision> getRevisionFromJson(String json) {
        Configuration configuration = new Configuration();
        configuration.config();

        TypeRef<List<Revision>> typeRef = new TypeRef<>() {};

        return JsonPath.parse(json).read("$..revisions[:31]", typeRef);
    }


}
