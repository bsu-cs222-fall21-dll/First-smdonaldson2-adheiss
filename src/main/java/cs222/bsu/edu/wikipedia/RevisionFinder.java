package cs222.bsu.edu.wikipedia;


import com.google.gson.GsonBuilder;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.TypeRef;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class RevisionFinder {
    //temporary function for testing
    public String getRevisionFromResponse(InputStream inputStream) throws IOException {
        ArrayList<String> username = JsonPath.read(inputStream, "$..revisions[*]..user");
        return username.get(0);

    }

    public List<Revision> getRevisionFromJson(String json) {
        //sets configuration to load/parse JSON
        Configuration.setDefaults(new Configuration.Defaults() {

            private final JsonProvider jsonProvider = new GsonJsonProvider(new GsonBuilder().serializeNulls().create());
            private final MappingProvider mappingProvider = new GsonMappingProvider();

            public JsonProvider jsonProvider() {
                return jsonProvider;
            }

            public MappingProvider mappingProvider() {
                return mappingProvider;
            }

            public Set<Option> options() {
                return EnumSet.noneOf(Option.class);
            }
        });
        TypeRef<List<Revision>> typeRef = new TypeRef<>() {};

       // for(int i = 0; i<=30; i++)
        return JsonPath.parse(json).read("$..revisions[2]", typeRef);

    }


}
