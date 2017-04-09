import java.util.ArrayList;

public class Party{

  private String name = "";
  private int votes = 0;
  private ArrayList<Candidate> candidates = new ArrayList<>();

  public Party(){
  }

  public Party(String name){
    this.name = name;
  }

  public void addCanditate(Candidate candidate){
    this.candidates.add(candidate);
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public void addVote(){
    votes++;
  }

  public int getVotes(){
    return votes;
  }



}
