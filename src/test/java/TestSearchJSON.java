import cs222.bsu.edu.wikipedia.searchJSON;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSearchJSON {
    @Test
    public void testSearchInput(){
        searchJSON search = new searchJSON();
        String result = search.searchInput("zappa");

        Assertions.assertEquals("{\"batchcomplete\":\"\",\"continue\":{\"sroffset\":5,\"continue\":\"-||\"},\"query\":{\"searchinfo\":{\"totalhits\":3823},\"search\":[{\"ns\":0,\"title\":\"Frank Zappa\",\"pageid\":10672,\"size\":160715,\"wordcount\":17704,\"snippet\":\"Frank Vincent <span class=\\\"searchmatch\\\">Zappa</span> (December 21, 1940\\u00a0\\u2013 December 4, 1993) was an American musician, composer, songwriter, and bandleader. His work is characterized by\",\"timestamp\":\"2021-09-25T15:09:12Z\"},{\"ns\":0,\"title\":\"Dweezil Zappa\",\"pageid\":239034,\"size\":19800,\"wordcount\":2122,\"snippet\":\"Dweezil <span class=\\\"searchmatch\\\">Zappa</span> (born Ian Donald Calvin Euclid <span class=\\\"searchmatch\\\">Zappa</span>; September 5, 1969) is an American rock guitarist and occasional actor. He is the son of musical composer\",\"timestamp\":\"2021-08-04T05:15:29Z\"},{\"ns\":0,\"title\":\"Zappa Plays Zappa\",\"pageid\":5378569,\"size\":18686,\"wordcount\":1588,\"snippet\":\"<span class=\\\"searchmatch\\\">Zappa</span> Plays <span class=\\\"searchmatch\\\">Zappa</span> is an American tribute act led by Dweezil <span class=\\\"searchmatch\\\">Zappa</span>, the eldest son of late American composer and musician Frank <span class=\\\"searchmatch\\\">Zappa</span>, devoted to performing\",\"timestamp\":\"2021-07-08T02:28:23Z\"},{\"ns\":0,\"title\":\"Ahmet Zappa\",\"pageid\":679542,\"size\":11415,\"wordcount\":1162,\"snippet\":\"Ahmet Emuukha Rodan <span class=\\\"searchmatch\\\">Zappa</span> (born May 15, 1974) is an American musician and writer, and trustee of the <span class=\\\"searchmatch\\\">Zappa</span> Family Trust. Ahmet <span class=\\\"searchmatch\\\">Zappa</span> was born in Los Angeles\",\"timestamp\":\"2021-05-23T15:51:57Z\"},{\"ns\":0,\"title\":\"Frank Zappa discography\",\"pageid\":2456113,\"size\":75026,\"wordcount\":1624,\"snippet\":\"by Frank <span class=\\\"searchmatch\\\">Zappa</span>, including all those credited to the Mothers of Invention. During his lifetime, <span class=\\\"searchmatch\\\">Zappa</span> released 62 albums. Since 1994, the <span class=\\\"searchmatch\\\">Zappa</span> Family Trust\",\"timestamp\":\"2021-09-24T19:15:56Z\"}]}}", result);
    }
}
