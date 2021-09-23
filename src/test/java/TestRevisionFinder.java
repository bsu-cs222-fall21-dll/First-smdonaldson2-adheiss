
import cs222.bsu.edu.wikipedia.Revision;

import cs222.bsu.edu.wikipedia.RevisionFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestRevisionFinder {
    @Test
    public void testGetRevisionFromResponse() throws IOException {
        RevisionFinder finder = new RevisionFinder();
        InputStream jsonResponse = Thread.currentThread().getContextClassLoader().getResourceAsStream("testresponse.json");
        Assertions.assertEquals("75.172.213.218", finder.getRevisionFromResponse(jsonResponse));
    }


    @Test
    public void testGetRevisionFromJson() {
        RevisionFinder finder = new RevisionFinder();
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
        Revision revision = finder.getRevisionFromJson(json).get(0);
        Assertions.assertEquals("75.172.213.218", revision.user);
        Assertions.assertEquals("fix numbers", revision.comment);
    }

}
