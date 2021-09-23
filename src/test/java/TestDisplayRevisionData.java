import cs222.bsu.edu.wikipedia.DisplayRevisionData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDisplayRevisionData {
    @Test
    public void testPrintToConsole(){
        //json is what display data shows
        String json = "{\n" +
                "  \"continue\": {\n" +
                "    \"rvcontinue\": \"20210919005429|1045132628\",\n" +
                "    \"continue\": \"||\"\n" +
                "  },\n" +
                "  \"query\": {\n" +
                "    \"normalized\": [\n" +
                "      {\n" +
                "        \"from\": \"Frank_Zappa\",\n" +
                "        \"to\": \"Frank Zappa\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"pages\": {\n" +
                "      \"10672\": {\n" +
                "        \"pageid\": 10672,\n" +
                "        \"ns\": 0,\n" +
                "        \"title\": \"Frank Zappa\",\n" +
                "        \"revisions\": [\n" +
                "          {\n" +
                "            \"user\": \"75.172.213.218\",\n" +
                "            \"anon\": \"\",\n" +
                "            \"timestamp\": \"2021-09-19T01:09:23Z\",\n" +
                "            \"comment\": \"fix numbers\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        DisplayRevisionData data = new DisplayRevisionData();
        data.revisionData(json);

    }
}
