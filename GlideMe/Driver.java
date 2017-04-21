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
    
    String startingPoint = inputLines[0];
    String hoopTop = inputLines[1];
    String hoopBottom = inputLines[2];
    String actions = inputLines[3];

    GlidePoint start = new GlidePoint(startingPoint);
    GlidePoint top = new GlidePoint(hoopTop);
    GlidePoint bottom = new GlidePoint(hoopBottom);

    start.glide(actions, top, bottom);
   


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
