package cs222.bsu.edu.wikipedia;

public class DisplaySearchResults {

    public String searchData(){
        String input = UserInput.getInput();

        searchJSON searchJSON = new searchJSON();
        String json = searchJSON.searchInput(input);

        searchFinder finder = new searchFinder();
        for(int i = 0;i<5;i++){
            search search = finder.getSearchFromJson(json).get(i);
            String title = search.title;

            System.out.println(ConsoleColors.GREEN + "Search Result #"+ (i+1) + ". " + title + ConsoleColors.RESET);
        }
        return UserInput.getSearchInput();




    }


}
