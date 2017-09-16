//4.23
import java.util.Scanner;

public class FinancialPayroll {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Get payroll info from user
		System.out.print("Enter employees name: ");
		String name = input.next();
		System.out.print("Enter number of hours worked in a week: ");
		double hoursWorked = input.nextDouble();
		System.out.print("Enter hourly pay rate: ");
		double hourlyPayRate = input.nextDouble();
		System.out.print("Enter federal tax withholding rate: ");
		double federalTaxRate = input.nextDouble();
		System.out.print("Enter state tax withholding rate: ");
		double stateTaxRate = input.nextDouble();
		
		//Output
		double grossPay, federal, state, totalDeduction;
		System.out.print(
				"Employee Name: " + name + 
				"\nHours Worked: " + hoursWorked +
				"\nPay Rate: $" + hourlyPayRate +
				"\nGross Pay: $" + (grossPay = hoursWorked * hourlyPayRate) +
				"\nDeductions:\n Federal Withholding (20.0%): $" +
			    (federal = grossPay * federalTaxRate) + 
			    "\n State Withholding (9.0%): $" + (state = grossPay * stateTaxRate) +
			    "\n Total Deduction: $" + (totalDeduction = federal + state) + 
			    "\nNet Pay: $" + (grossPay - totalDeduction));
	}

}
