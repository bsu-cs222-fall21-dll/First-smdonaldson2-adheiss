package cs222.bsu.edu.wikipedia;

public class DisplaySearchResults {

    public String[] searchData(String input){
//        String input = UserInput.getInput();
        String[] resultArray = new String[5];

        searchJSON searchJSON = new searchJSON();
        String json = searchJSON.searchInput(input);
        Finder finder = new Finder();
        if(finder.getSearchFromJson(json).size()==0){
            Errors errors = new Errors();
            errors.exitCodeTwo();
        }
        for(int i = 0;i<5;i++){
            search search = finder.getSearchFromJson(json).get(i);
            String title = search.title;
            resultArray[i] = title;

            System.out.println(ConsoleColors.GREEN + "Search Result #"+ (i+1) + ". " + title + ConsoleColors.RESET);
        }
        return resultArray;
//        String searchInput = UserInput.getSearchInput();
//        String returnedSearch = "";
//
//        if(searchInput.equals("1")){
//            returnedSearch = resultArray[0];
//        }
//        else if(searchInput.equals("2")){
//            returnedSearch = resultArray[1];
//        }
//        else if(searchInput.equals("3")){
//            returnedSearch = resultArray[2];
//        }
//        else if(searchInput.equals("4")){
//            returnedSearch = resultArray[3];
//        }
//        else if(searchInput.equals("5")){
//            returnedSearch = resultArray[4];
//        }
//
//        return returnedSearch.replaceAll("\\s+","_");
//
    }


}
