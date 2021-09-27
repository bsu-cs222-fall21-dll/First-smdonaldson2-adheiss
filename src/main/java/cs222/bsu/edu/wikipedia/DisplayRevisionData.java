package cs222.bsu.edu.wikipedia;

public class DisplayRevisionData {

    private void printToConsole(String user, String comment, String timestamp ){
        System.out.println("User: " + user + "\nComment: "+ comment + "\nTimestamp: " + timestamp );
    }

    public void revisionData(String json){

        RevisionFinder finder = new RevisionFinder();

        for(int i = 0;i<30;i++){
            Revision revision = finder.getRevisionFromJson(json).get(i);
            String user = revision.user;
            String comment = revision.comment;
            String timestamp = revision.timestamp;

            System.out.println(ConsoleColors.RED+"Revision Number: "+ (i+1) + ConsoleColors.RESET);


            printToConsole(user,comment,timestamp);
        }


    }
}
