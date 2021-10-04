package cs222.bsu.edu.wikipedia;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


public class Controller {
    @FXML
    private final ListView<String> list = new ListView<String>();
    @FXML
    private Button bInputSave = new Button("Save");
    @FXML
    private TextField input;
    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<String>();

    public void Search() throws MalformedURLException, URISyntaxException {
        String input = buttonClick();
        DisplaySearchResults displaySearchResults = new DisplaySearchResults();
        String[] searchResult = displaySearchResults.searchData(input);
        populateChoiceBox(searchResult);
    }
    public void getRevisions(){
        System.out.println(ConsoleColors.PURPLE + "Redirected you to: " + searchResult + ConsoleColors.RESET);
        URL url = new URL("https://www.wikipedia.org/w/api.php");
        GetJSONRevision getJSONData = new GetJSONRevision();
        URL newUrl = GetJSONRevision.concatenate(url, searchResult);
        String json = getJSONData.getSiteData(newUrl);

        DisplayRevisionData displayRevisionData = new DisplayRevisionData();
        displayRevisionData.revisionData(json);
    }
    public String buttonClick(){
        bInputSave.setDisable(true);
        return input.getText();
    }
    public void populateChoiceBox(String[] input){
        for (String s : input) {
            choiceBox.getItems().add(s);
        }
    }




}
