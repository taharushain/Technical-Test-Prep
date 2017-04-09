import java.util.ArrayList;

public class CallCenter implements CallHandler{

  private ArrayList<Employee> juniors = new ArrayList<>();
  private Employee technicalLead;
  private Employee productManager;


  public CallCenter(){

  }

  public void addJunior(Employee employee){
    juniors.add(employee);
  }
  public Employee getEmployee(int index){
    return juniors.get(index);
  }
  public void setTechnicalLead(Employee employee){
    this.technicalLead = employee;
  }

  public void setProductManager(Employee employee){
    this.productManager = employee;
  }

  @Override
  public Employee getCallHandler(){

    for(int i=0; i < juniors.size(); i++){
      if(juniors.get(i).isAvailable() && juniors.get(i).canHandle()){
        juniors.get(i).setAvailable(false);
        return juniors.get(i);
      }
    }

    if(technicalLead.isAvailable() && technicalLead.canHandle()){
      technicalLead.setAvailable(false);
      return technicalLead;
    }else{
      return productManager;
    }

  }

}
