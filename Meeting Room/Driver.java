import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class Driver{

  private static final String fileName = "sampleInput.txt";

  public static void main(String[] args){

    String input = getFileInput();
    String[] inputLines = input.split("[\n|\r]");
    int numberOfBookings = Integer.parseInt(inputLines[0]);

    
    int indexBookingStart = 0;

    while(numberOfBookings > 0){
      Schedular schedular = new Schedular();
      for(int i=(indexBookingStart + 1); i <= (numberOfBookings+indexBookingStart); i++){
        Boolean conflict = false;
        String inputTime = inputLines[i];
        String startTime = inputTime.split("-")[0];
        String endTime = inputTime.split("-")[1];
        Booking booking = new Booking(startTime, endTime);
        conflict = schedular.handleBookings(booking);

        if(conflict){
          System.out.println("conflict");
          indexBookingStart+= numberOfBookings + 1;
          break;
        }

        if(i >= (numberOfBookings+indexBookingStart)){
          System.out.println("no conflict");
          indexBookingStart += numberOfBookings + 1;
          break;
        }

      }
      numberOfBookings = Integer.parseInt(inputLines[indexBookingStart]);
    }
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
