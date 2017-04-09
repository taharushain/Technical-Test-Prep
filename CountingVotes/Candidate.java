public class Candidate{
  private String name = "";
  private Party party;
  private int votes = 0;
  private boolean hasParty = false;

  public Candidate(){
    name = "John Doe";
  }

  public Candidate(String name){
    this.name = name;
  }

  public Candidate(String name, Party party){
    this.name = name;
    this.party = party;
    hasParty = true;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setParty(Party party){
    this.party = party;
    hasParty = true;
  }

  public String getName(){
    return name;
  }

  public Party getParty(){
    return party;
  }

  public void addVote(){
    this.votes++;
  }

  public int getVotes(){
    return votes;
  }

  public boolean hasParty(){
    return hasParty;
  }

}
