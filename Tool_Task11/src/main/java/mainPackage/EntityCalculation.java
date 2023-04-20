package mainPackage;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class EntityCalculation {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    int ID ;   
  
	private int number1,number2;
	public int getNumber1() {
		return number1;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	private String operation ;
	
	
}
