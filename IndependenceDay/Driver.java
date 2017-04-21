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
    int numberOfPatterns = Integer.parseInt(inputLines[0]);

   for(int i = 1; i <= numberOfPatterns; i++){
      String line = inputLines[i];
      String pattern = line.split(" ")[0];
      int ith = Integer.parseInt(line.split(" ")[1]);
      int jth = Integer.parseInt(line.split(" ")[2]);
      System.out.println(getNumWhite(pattern, ith, jth));
   }


  }

  private static int getNumWhite(String pattern, int ith, int jth){
    int whiteCount = 0;
    while(pattern.length() < jth){
      pattern+=pattern;
    }

    for(int i = ith-1; i < jth; i++){
      char flag = pattern.charAt(i);
      if(flag == 'w' || flag == 'W'){
        whiteCount++;
      }

    }
    return whiteCount;
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
