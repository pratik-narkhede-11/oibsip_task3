
import java.util.Scanner;

class Bankaccount
{
	String Name;
	String username;
	int pin;
	String accountno;
	float balance=0;//initially Balance is kept as 0
	int trans=0;
	String TransactionHistory="";
	
	public void register() {
		
		System.out.print("\n********************\n");
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter Your Name : ");
		this.Name=sc.nextLine();
		System.out.println("\nEnter Your Username : ");
		this.username=sc.nextLine();
		System.out.println("\nEnter Your Pin : ");
		this.pin=sc.nextInt();
		System.out.println("\nEnter Your Account Number : ");
		this.accountno=sc.nextLine();
		
		System.out.println("\nRegistration is Succesfully Completed Kindly Proceed to Login\n\n");
		
		System.out.print("\n********************\n");
	}
	
	public boolean login() {
		boolean islogin = false;
		Scanner sc = new Scanner(System.in);
		while(!islogin)
		{
			System.out.print("\n********************\n");
			System.out.println("\nEnter Your Username : ");
			String Username=sc.nextLine();
			
			if(Username.equals(username)) {
				while(!islogin)
				{
					System.out.println("\nEnter Your Pin : ");
					int Pin=sc.nextInt();
					
					if(Pin==pin) {
						System.out.println("\nLogin Succesfully !!!\n\n");
						islogin=true;
						System.out.print("\n********************\n");
					}
					else
					{
						System.out.println("\nIncorrect pin\n\n");
						
						System.out.print("\n********************\n");
					}
				}
			}
			else
			{
				System.out.println("\nInvalid Username.\n\n");
				System.out.print("\n********************\n");
			}
		}
		return islogin;
		
	}
	
	public void Withdraw()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n********************\n");
		
		System.out.print("\nEnter the amount to Withdraw : ");
		float amount =sc.nextFloat();
		
			if(balance >= amount )
			{
				trans++;
				balance -= amount;
				System.out.print("\nWithdraw Sccessfully !!! \n\n");
				String str=amount + "Rs withdrawn\n";
				TransactionHistory = TransactionHistory.concat(str);
				
				System.out.print("\n********************\n");
			}
			else
			{
				System.out.print("\nInsufficient balance to make transactions\n\n");
				
				System.out.print("\n********************\n");
			}
		
	}
	
	public void Deposit()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\n********************\n");
		System.out.print("\nEnter the amount to Deposit : ");
		float amount =sc.nextFloat();
		
			if(amount<= 100000f)
			{
				trans++;
				balance += amount;
				System.out.print("\nDeposited Sccessfully !!! \n\n");
				String str=amount + "Rs deposited\n";
				TransactionHistory = TransactionHistory.concat(str);
				System.out.print("\n********************\n");
			}
			else
			{
				System.out.print("\nSorry.Can deposit only upto limit of 100000.0\n\n");
				
				System.out.print("\n********************\n");
			}
		
		
	}
	
	public void Transfer()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\n********************\n");
		System.out.print("\nEnter the Recipents name : ");
		String recipent =sc.nextLine();
		System.out.print("\nEnter the amount to Deposit : ");
		float amount =sc.nextFloat();
		
			if(balance>=amount)
			{
				if(amount<=50000f)
				{
					trans++;
					balance -= amount;
					System.out.print("\nTransfered Sccessfully !!! \n\n");
					String str=amount + "Rs Transfered to "+ recipent+"\n";
					TransactionHistory = TransactionHistory.concat(str);
					
					System.out.print("\n********************\n");
				}
				else
				{
					System.out.print("\nSorry.Can Tranfer only upto limit of 50000.00\n\n");
					
					System.out.print("\n********************\n");
				}
			}
			else
			{
				System.out.print("\nNot Sufficient Balance\n\n");
				
				System.out.print("\n********************\n");
			}
		
	}
	
	public void CheckBalance()
	{
		System.out.print("\n********************\n");
		System.out.print("\nBalance : "+balance+"Rs\n\n");
		System.out.print("\n********************\n");
	}
	
	public void TransactionHistory() {
		if(trans == 0)
		{
			System.out.print("\n********************\n");
			System.out.print("\nNo Transactions Performed\n\n");
			System.out.print("\n********************\n");
		}
		else
		{
			System.out.print("\n********************\n");
			System.out.print("\n"+TransactionHistory+"\n\n");
			System.out.print("\n********************\n");
		}
	}
	
}
public class ATM_Machine {
	
	

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int choice,ch,c;
		System.out.print("\n********************\n");
		System.out.print("\n******WELCOME*****\n");
		System.out.print("\nENTER YOUR CHOICE : \n");
		System.out.println("1)REGISTER");
		System.out.println("2)EXIT");
		System.out.println("(1,2):");
		choice =sc.nextInt();
		System.out.print("\n********************\n");
		
		switch(choice)
		{
		case 1:
			Bankaccount b = new Bankaccount();
			b.register();
			
			
			while(true) {
				System.out.print("\nENTER YOUR CHOICE : \n");
				System.out.println("1)LOGIN");
				System.out.println("2)EXIT");
				System.out.println("(1,2):");
				ch = sc.nextInt();
				
				switch(ch)
				{
				case 1:
					if(b.login())
					{
						System.out.print("\n******WELCOME "+b.Name+" TO ATM*****\n");
						
						do
						{
							System.out.print("\nENTER YOUR CHOICE : \n");
							System.out.println("1)WITHDRAW");
							System.out.println("2)DEPOSIT");
							System.out.println("3)TRANFER");
							System.out.println("4)CHECK BALANCE");
							System.out.println("5)TRANSACTION HISTORY");
							System.out.println("6)EXIT");
							System.out.println("(1,2,3,4,5,6):");
							c =sc.nextInt();
							
							switch(c)
							{
							case 1:
								b.Withdraw();
								break;
							case 2:
								b.Deposit();
								break;
							case 3:
								b.Transfer();
								break;
							case 4:
								b.CheckBalance();
								break;
							case 5:
								b.TransactionHistory();
								break;
							case 6:
								System.out.println("Exit");
								break;
							default:
								System.out.println("Wrong choice");
							}
						}while(c!=6);
					}
					break;
				case 2:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong choice");
				}
				
				
			}
			//break;
		case 2:
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choice");
		}
		
	}
}
