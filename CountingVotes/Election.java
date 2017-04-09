import java.util.ArrayList;

public class Election{
  private String name = "";
  private ArrayList<Candidate> candidates = new ArrayList<>();
  private ArrayList<Party> parties = new ArrayList<>();

  public Election(String name){
    this.name = name;

  }

  public void addCanditate(Candidate candidate){
    if(!candidateExists(candidate.getName())){
      candidates.add(candidate);
    }
  }

  public void addParty(Party party){
    if(!partyExists(party.getName())){
      parties.add(party);
    }
  }

  public String getWinnerCandidate(){

    if(isTie()){
      return "Tie";
    }else{
      return candidates.get(getHighestVotesBy()).getName();
    }

  }

  public String getWinnerParty(){
    int index = -1, count = -1;
    for(int i =0; i < parties.size(); i++){
        if(parties.get(i).getVotes() > count){
          count = parties.get(i).getVotes();
          index = i;
        }
    }

    if(index == -1){
      return "None";
    }else{
      return parties.get(index).getName();
    }
  }

  public void castVote(String candidateName){
    for(int i=0; i< candidates.size(); i++){
      if(candidates.get(i).getName().trim().equals(candidateName)){

        candidates.get(i).addVote();
        if(candidates.get(i).hasParty())
          candidates.get(i).getParty().addVote();
        return;
      }
    }
  }

  private boolean candidateExists(String name){
    for(int i = 0; i < candidates.size(); i++){
      if(candidates.get(i).getName().trim().toLowerCase().equals(name.trim().toLowerCase())){
        return true;
      }
    }
    return false;
  }

  private boolean partyExists(String name){
    for(int i = 0; i < parties.size(); i++){
      if(parties.get(i).getName().trim().toLowerCase().equals(name.trim().toLowerCase())){
        return true;
      }
    }
    return false;
  }

  private int getHighestVotesBy(){
    int index = -1, count = -1;
    for(int i =0; i < candidates.size(); i++){
        if(candidates.get(i).getVotes() > count){
          count = candidates.get(i).getVotes();
          index = i;
        }
    }

    if(index == -1){
      return -1;
    }else{
      return index;
    }
  }

  private int getSecondHighestVotesBy(){
    int index = -1, count = -1;
    int highestVotesBy = getHighestVotesBy();

    for(int i = 0; i < candidates.size(); i++){

        if(i == highestVotesBy){
          continue;
        }

        if(candidates.get(i).getVotes() > count){
          count = candidates.get(i).getVotes();
          index = i;
        }
    }

    if(index == -1){
      return -1;
    }else{
      return index;
    }
  }

  private boolean isTie(){
    if(candidates.get(getHighestVotesBy()).getVotes() == candidates.get(getSecondHighestVotesBy()).getVotes()){
      return true;
    }else{
      return false;
    }
  }


}
