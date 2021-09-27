package cs222.bsu.edu.wikipedia;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.TypeRef;

import java.util.List;


public class searchFinder {
    public List<search> getSearchFromJson(String json) {
        Configuration configuration = new Configuration();
        configuration.config();

        TypeRef<List<search>> typeRef = new TypeRef<>() {};

        return JsonPath.parse(json).read("$..search[0]", typeRef);

    }
}
