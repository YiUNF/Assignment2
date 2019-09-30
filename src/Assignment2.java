import java.util.Scanner;

public class Assignment2 {

	public static void main(String[] args) {
		CustomerList cl = new CustomerList();	// instantiate a Customer List
		Customer c = null;
		boolean continueToPrompt = true;
		do
		{
				
			System.out.println("Please enter a selection between 1 to 62\r\n" +"" +
					"1. Add Customer\r\n" + 
					"2. Delete Customer\r\n" + 
					"3. View Customer List\r\n" + 
					"4. Find Customer\r\n" + 
					"5. Sort Customer List\r\n" + 
					"6. Quit"); // display options
			Scanner input = new Scanner(System.in); 
			// prompt and get user input
		
			String name;
			int option = -1;
			
			// Make sure the input is a valid int
			try
			{
				option = input.nextInt();
			}
			catch (Exception e)
			{
				continue;
			}
			
			switch (option) 
			{
			case 1: 
				System.out.println("Please enter customer name: ");
				name = input.next();
				
				if (cl.AddCustomer(name))
					System.out.println(name + " is added.");
				else
					System.out.println(name + " is not added.");
					
				break;
			case 2:
				System.out.println("Please enter customer name: ");
				name = input.next();
				boolean result = cl.DeleteCustomer(name);
				if(result)
				{
					System.out.println("Customer is found and removed successfully!");
				}
				else
				{
					System.out.println("Customer is not found");
				}
				break;
				
			case 3:
				System.out.println("List all the customers...");
				cl.ViewCustomerList();
				break;
			case 4:
				System.out.println("Please enter customer name: ");
				name = input.next();
				c = cl.FindCustomer(name);
				if(c != null)
				{
					System.out.println("Customer is found!");
				}
				else
				{
					System.out.println("Customer is not found");
				}
				break;
			case 5:
				cl.SortCustomerList();
				cl.ViewCustomerList();				
				break;
			case 6:
				System.out.println("Goodbye");
				continueToPrompt = false;
				break;
			default:
				System.out.println("Please input only option 1 to 6.");
				break;
			}
		} while (continueToPrompt);	
		
	}

}
