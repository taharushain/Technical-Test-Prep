public class Employee{

private boolean available = true;
private boolean canHandle = true;
private String type = "Junior";

public Employee(String type){
  this.type = type;
}

public Employee(boolean available, boolean canHandle){
  this.available = available;
  this.canHandle = canHandle;
}

public Employee(){

}


public boolean isAvailable(){
  return available;
}

public boolean canHandle(){
  return canHandle;
}

public void setAvailable(boolean available){
  this.available = available;
}

public void setCanHandle(boolean canHandle){
  this.canHandle = canHandle;
}

@Override
public String toString(){
  return "Employee: "+type;
}

}
