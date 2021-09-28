package cs222.bsu.edu.wikipedia;

import java.util.Objects;

public class DisplaySearchResults {

    public String searchData(){
        String input = UserInput.getInput();

        searchJSON searchJSON = new searchJSON();
        String json = searchJSON.searchInput(input);
        Finder finder = new Finder();
        if(finder.getSearchFromJson(json).size()==0){
            System.err.println("Your search did not exist");
            System.exit(2);
        }

        for(int i = 0;i<5;i++){
            search search = finder.getSearchFromJson(json).get(i);
            String title = search.title;

            System.out.println(ConsoleColors.GREEN + "Search Result #"+ (i+1) + ". " + title + ConsoleColors.RESET);
        }
        return UserInput.getSearchInput();

    }


}
