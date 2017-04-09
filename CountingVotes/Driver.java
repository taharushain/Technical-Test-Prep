import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class Driver{

  private static final String fileName = "sampleInput.txt";
  private static Election election;

  public static void main(String[] args){

    election = new Election("Super Election 2017");

    String input = getFileInput();
		String[] inputLines = input.split("[\n|\r]");
		int numberOfCandidates = Integer.parseInt(inputLines[0]);

		for(int i = 1; i <= numberOfCandidates; i++){
			String candidateName = inputLines[i].split(",")[0].trim();
			String partyName = inputLines[i].split(",")[1].trim();



      if (!partyName.trim().toLowerCase().equals("independent")) {
        Party party = new Party(partyName);
        Candidate candidate = new Candidate(candidateName, party);
        party.addCanditate(candidate);
        election.addCanditate(candidate);
        election.addParty(party);
      }else{
        Candidate candidate = new Candidate(candidateName);
        election.addCanditate(candidate);
      }
		}

    for(int i = numberOfCandidates+1; i < inputLines.length; i++){

        String candidateName = inputLines[i].trim();
        election.castVote(candidateName.trim());
    }

    System.out.println("\n\nWinner Party: "+ election.getWinnerParty());
    System.out.println("Winner Candidate: " + election.getWinnerCandidate());


  }

  private static String getFileInput(){
  		String text = "";
  	    try{
  	      Stream<String> stream = Files.lines(Paths.get(fileName));

  	      Iterator<String> iterator = stream.iterator();
  	      while(iterator.hasNext()){
  	    	  text+= iterator.next()+"\n";
  	      }


  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  	    return text.trim();
}


}
