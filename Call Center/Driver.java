public class Driver{

  public static void main(String[] args){
    CallCenter callCenter = new CallCenter();
    Employee employeeOne = new Employee();
    Employee employeeTwo = new Employee();
    Employee employeeThree = new Employee();

    Employee technicalLead = new Employee("Technical Lead");
    Employee productManager = new Employee("Product Manager");

    callCenter.addJunior(employeeOne);
    callCenter.addJunior(employeeTwo);
    callCenter.addJunior(employeeThree);
    callCenter.setTechnicalLead(technicalLead);
    callCenter.setProductManager(productManager);

    System.out.println(callCenter.getCallHandler());
    System.out.println(callCenter.getCallHandler());
    System.out.println(callCenter.getCallHandler());
    System.out.println(callCenter.getCallHandler());
    System.out.println(callCenter.getCallHandler());
    System.out.println(callCenter.getCallHandler());
    technicalLead.setAvailable(true);
    employeeOne.setAvailable(true);
    System.out.println(callCenter.getCallHandler());
    System.out.println(callCenter.getCallHandler());
    System.out.println(callCenter.getCallHandler());


  }
}
