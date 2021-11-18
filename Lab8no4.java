package lab8;
import java.util.*;
abstract class Employee{
    private String firstname;
    private String lastname;
    private String id;
    public Employee(String firstname,String lastname,String id){
        this.firstname=firstname;
        this.lastname=lastname;
        this.id=id;
    }
    public abstract double earning();
    public abstract double bonus(int year);
    String getfirstname(){
        return firstname;
    }
    String getlastname(){
        return lastname;
    }
    String getID(){
        return id;
    }
}
class SalariedEmployee extends Employee{
    private double salary;
    public SalariedEmployee(String firstname,String lastname,String id, double sal){
        super(firstname,lastname,id);
        this.salary=sal;  
    }
//    @Override
    public double earning() {
        return this.salary-(5.0/100*this.salary);
    }
//    @Override
    public double bonus(int year) {
        if(year>5){
            return 12*this.salary;
        }else{
            return 6*this.salary;
        }
    }   
}
class ComEmployee extends Employee{
    private double grossSale;
    private double ComRate;
    public ComEmployee(String firstname,String lastname,String id, double sales, double percent){
        super(firstname,lastname,id);
        this.grossSale=sales;
        this.ComRate=percent;
    }
    @Override
    public double earning() {
        return this.ComRate*this.grossSale;
    }
    @Override
    public double bonus(int year) {
        if(year>5){
            return 6*this.grossSale;
        }else{
            return 3*this.grossSale;
        }

    }
    
}
public class Lab8no4 {
    static void printEmp(ArrayList a){
        System.out.println(" |ID\t|Fisrtname Lastname\t|Earning\t|Bonus  \t|");
        for(int i=0;i<a.size();i++){
            if(a.get(i) instanceof SalariedEmployee){
                System.out.print(i+1);
                System.out.format("|%5s\t", ((SalariedEmployee)a.get(i)).getID());
                System.out.format("|%9s ", ((SalariedEmployee)a.get(i)).getfirstname());
                System.out.format("%8s\t", ((SalariedEmployee)a.get(i)).getlastname());
                System.out.format("|%7.2f\t|", ((SalariedEmployee)a.get(i)).earning());
                System.out.format("%5.2f\t|\n", ((SalariedEmployee)a.get(i)).bonus(i+5)); 
            }
            if(a.get(i) instanceof ComEmployee){
                System.out.print(i+1);
                System.out.format("|%5s\t", ((ComEmployee)a.get(i)).getID());
                System.out.format("|%9s ", ((ComEmployee)a.get(i)).getfirstname());
                System.out.format("%8s\t", ((ComEmployee)a.get(i)).getlastname());
                System.out.format("|%7.2f\t|", ((ComEmployee)a.get(i)).earning());
                System.out.format("%5.2f\t|\n", ((ComEmployee)a.get(i)).bonus(i+3));
            }
            
            
        }
        
    }
    public static void main(String[] args) {
        ArrayList Emp=new ArrayList();
        SalariedEmployee emp1=new SalariedEmployee("test1","tess","11163",2000);
        SalariedEmployee emp2=new SalariedEmployee("test2","tess","11164",2000);
        ComEmployee emp3=new ComEmployee("test3","tess","22263",2000,5);
        ComEmployee emp4=new ComEmployee("test4","tess","22264",2000,10);
        Emp.add(emp1);
        Emp.add(emp2);
        Emp.add(emp3);
        Emp.add(emp4);
        printEmp(Emp);
    }
    
}
