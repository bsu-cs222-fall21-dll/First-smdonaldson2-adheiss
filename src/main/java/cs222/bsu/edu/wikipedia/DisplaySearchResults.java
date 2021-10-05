package cs222.bsu.edu.wikipedia;

public class DisplaySearchResults {

    public String[] searchData(String input){
        String[] resultArray = new String[5];

        searchJSON searchJSON = new searchJSON();
        String json = searchJSON.searchInput(input);
        Finder finder = new Finder();
        if(finder.getSearchFromJson(json).size()==0){
            return resultArray;
        }
        else{
            for(int i = 0;i< 5;i++){
                search search = finder.getSearchFromJson(json).get(i);
                String title = search.title;
                resultArray[i] = title;
            }
        }
        return resultArray;
    }

    public String searchDataConsole(){
        String input = UserInput.getInput();
        String[] resultArray = searchData(input);

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
        }

        for(int i = 0; i<5;i++){
            System.out.println(ConsoleColors.GREEN + "Search Result #" + (i+1) + " " + resultArray[i] + ConsoleColors.RESET);
        }

        searchData(input);
        String searchInput = UserInput.getSearchInput();
        String returnedSearch = switch (searchInput) {
            case "1" -> resultArray[0];
            case "2" -> resultArray[1];
            case "3" -> resultArray[2];
            case "4" -> resultArray[3];
            case "5" -> resultArray[4];
            default -> "";
        };

        return returnedSearch.replaceAll("\\s+","_");
    }


}
