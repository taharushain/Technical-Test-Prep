import java.time.LocalTime;

public class Booking{

  private LocalTime mStartTime;
  private LocalTime mEndTime;

  public Booking(LocalTime mStartTime, LocalTime mEndTime){
    this.mStartTime = mStartTime;
    this.mEndTime = mEndTime;
  }

  public Booking(String mStartTime, String mEndTime){
    this.mStartTime = LocalTime.parse(mStartTime);
    this.mEndTime = LocalTime.parse(mEndTime);
  }


  public LocalTime getStartTime(){
    return mStartTime;
  }

  public LocalTime getEndTime(){
    return mEndTime;
  }

  public void setStartTime(LocalTime mStartTime){
    this.mStartTime = mStartTime;
  }

  public void setEndTime(LocalTime mEndTime){
    this.mEndTime = mEndTime;
  }

}
