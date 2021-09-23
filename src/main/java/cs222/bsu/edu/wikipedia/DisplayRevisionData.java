package cs222.bsu.edu.wikipedia;

public class DisplayRevisionData {
    //prints data to console
    private void printToConsole(String user, String comment, String timestamp, String anon){
        System.out.println("User: " + user + "\nComment: "+ comment + "\nTimestamp: " + timestamp + "\nAnon: " + anon);
    }
    //getting revision data from json
    public void revisionData(String json){
        //create new revision finder
        RevisionFinder finder = new RevisionFinder();
        //runs the json string through RevisionFinder class getRevisionFromJson to assign
        //values to objects declared in revision
        Revision revision = finder.getRevisionFromJson(json).get(0);
        String user = revision.user;
        String comment = revision.comment;
        String timestamp = revision.timestamp;
        String anon = revision.anon;
        //print function
        printToConsole(user,comment,timestamp,anon);
    }
}
