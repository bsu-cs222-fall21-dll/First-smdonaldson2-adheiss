package cs222.bsu.edu.wikipedia;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


public class Controller {
    @FXML
    private ListView<String> list;
    @FXML
    private Button bInputSave = new Button("Save");
    @FXML
    private TextField input;
    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();

    public void Search() throws MalformedURLException, URISyntaxException {
        String input = buttonClick();
        DisplaySearchResults displaySearchResults = new DisplaySearchResults();
        String[] searchResult = displaySearchResults.searchData(input);
        populateChoiceBox(searchResult);
    }
    public void getRevisions() throws MalformedURLException, URISyntaxException {
        System.out.println("getting json revision");
        String searchResult = getChoice(choiceBox);
        URL url = new URL("https://www.wikipedia.org/w/api.php");
        GetJSONRevision getJSONData = new GetJSONRevision();
        URL newUrl = GetJSONRevision.concatenate(url, searchResult);
        String json = getJSONData.getSiteData(newUrl);

        populateListView(json);
    }
    public void populateListView(String json){
        Finder finder = new Finder();
        System.out.println("filling revision");
        for(int i = 0;i<30;i++) {
            Revision revision = finder.getRevisionFromJson(json).get(i);
            String user = revision.user;
            String comment = revision.comment;
            String timestamp = revision.timestamp;
            list.getItems().addAll(user, comment, timestamp);
        }
    }

    public String buttonClick(){
        bInputSave.setDisable(true);
        return input.getText();
    }
    public String getChoice(ChoiceBox<String> choiceBox){
        System.out.println("choice box choice");
        return choiceBox.getValue();
    }
    public void populateChoiceBox(String[] input){
        System.out.println("filling choice box");
        for (String s : input) {
            choiceBox.getItems().add(s);
        }
    }




}
