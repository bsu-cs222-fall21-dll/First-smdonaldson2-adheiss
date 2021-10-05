package cs222.bsu.edu.wikipedia;

import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;


public class Controller {
    @FXML
    private ListView<String> list;
    @FXML
    private Button buttonSearch = new Button("Save");
    @FXML
    private TextField input;
    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();
    @FXML
    private final Dialog<String> dialog = new Dialog<>();
    @FXML
    private final Alert alert = new Alert(Alert.AlertType.ERROR);

    public void Search() throws MalformedURLException, URISyntaxException {
        String input = buttonClick();
        DisplaySearchResults displaySearchResults = new DisplaySearchResults();
        String[] searchResult;

        searchJSON json = new searchJSON();
        URL url = new URL("https://www.wikipedia.org/w/api.php");
        URL newUrl = json.concatenate(url, input);
        Errors errors = new Errors();
        if(errors.checkNetwork(newUrl).equals(Boolean.TRUE)){
            alert.setContentText("Network Error");
            alert.showAndWait();
            System.exit(3);
        }

        searchResult = displaySearchResults.searchData(input);
        populateChoiceBox(searchResult);
    }
    public void getRevisions() throws MalformedURLException, URISyntaxException {
        String searchResult = getChoice(choiceBox);

        URL url = new URL("https://www.wikipedia.org/w/api.php");
        GetJSONRevision getJSONData = new GetJSONRevision();
        URL newUrl = GetJSONRevision.concatenate(url, searchResult);
        Errors errors = new Errors();
        if(errors.checkNetwork(newUrl).equals(Boolean.TRUE)){
            alert.setContentText("Network Error");
            alert.showAndWait();
            System.exit(3);
        }


        String json = getJSONData.getSiteData(newUrl);

        populateListView(json);
    }
    private void populateListView(String json){
        Finder finder = new Finder();
        TimeConverter timeConverter = new TimeConverter();
        for(int i = 0;i<30;i++) {
            Revision revision = finder.getRevisionFromJson(json).get(i);
            String user = revision.user;
            String comment = revision.comment;
            String timestamp = timeConverter.convertTime(revision.timestamp);
            list.getItems().addAll( "Revision #" + (i+1),"User: " + user, "Comment: " + comment, "Timestamp: " + timestamp);
        }
    }
    private String buttonClick(){
        buttonSearch.setDisable(true);
        String search =  input.getText();
        return search.replaceAll("\\s+","_");
    }
    private void dialogBox(){
        dialog.setHeaderText("Hi, user, it seems you use Wikipedia Revisions a lot; thats great!\nIt's a little awkward to ask but we need your help.\n If you have already donated, we sincerely thank you. We're not\n salespeople, but we depend on donations averaging $13.42, and\n fewer than 2% of readers give. If you donate $2.01, the price of\n a cup of coffee, Wikipedia could keep thriving for years\n to come. Thank you.");

        Label label1 = new Label("16 Digits:");
        Label label2 = new Label("CVV:");
        Label label3 = new Label("Exp Date:");
        TextField text1 = new TextField();
        TextField text2 = new TextField();
        TextField text3 = new TextField();


        GridPane grid = new GridPane();
        grid.add(label1,1,1);
        grid.add(text1,2,1);
        grid.add(label2,1,2);
        grid.add(text2,2,2);
        grid.add(label3,1,3);
        grid.add(text3,2,3);
        dialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        dialog.showAndWait();
        dialog.getDialogPane().getButtonTypes().remove(buttonTypeOk);
    }
    public void resetClick() {
        input.clear();
        list.getItems().clear();
        choiceBox.getItems().clear();
        buttonSearch.setDisable(false);
        dialogBox();
    }
    private String getChoice(ChoiceBox<String> choiceBox){
        String choice = choiceBox.getValue();
        return choice.replaceAll("\\s+","_");
    }
    private void populateChoiceBox(String[] input){
        if(Objects.equals(input[0], null)){
            System.out.println("Hello");
            alert.setContentText("No Search Exists");
            alert.showAndWait();
            System.exit(2);
        }
        for (String s : input) {
            choiceBox.getItems().add(s);
        }
    }

}
