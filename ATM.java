import java.io.*;
import java.util.*;

public class ATM {
	public static void main(String[] args) {
		int balance = 0, withdraw, deposit;  
		Scanner sc = new Scanner(System.in); 
		int flag = 1; 
        System.out.println("\n.....WELCOME.....");
		System.out.println("Set PIN : ");
		int pin = sc.nextInt();
		System.out.println("your PIN is updated successfully \n You can remove your card\n\n\n");
		System.out.println(".....ATM.....");
		do
		{
		System.out.println("Insert your card and Enter your PIN");
		int p = sc.nextInt();
		if(p==pin)
		{
			flag = 0;
			while(true)  
			{  
				System.out.print("Choose the operation you want to perform:\n");
				System.out.println("Choose 1 for Withdraw");  
				System.out.println("Choose 2 for Deposit");  
				System.out.println("Choose 3 for Check Balance");  
				System.out.println("Choose 4 for EXIT");  
				int choice = sc.nextInt();  
				switch(choice)  
				{  
					case 1:  
						System.out.print("Enter money to be withdrawn:");    
						withdraw = sc.nextInt();               
						if(balance >= withdraw)  
						{   
							balance = balance - withdraw;  
							System.out.println("Please collect your money");  
						}  
						else  
						{      
							System.out.println("Insufficient Balance");  
						}  
						System.out.println("");  
					break;  
					case 2:  
						System.out.print("Enter money to be deposited:");  
						deposit = sc.nextInt();  
						balance = balance + deposit;  
						System.out.println("Your Money has been successfully depsited");  
						System.out.println("");  
					break;  
					case 3:  
						System.out.println("Balance : "+balance);  
						System.out.println("");  
					break;  
					case 4:  
						System.exit(0);  
				}	  
			} 
		} 
		else
		System.out.println("Incorrect PIN");
	}while (flag!=0);
}
}
