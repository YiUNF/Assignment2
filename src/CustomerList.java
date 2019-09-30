import java.util.ArrayList;

public class CustomerList {

	private ArrayList<Customer> customers;
	public CustomerList () 
	{
		customers = new ArrayList<Customer>();	
	}//create a new array list for Customer
	public boolean AddCustomer (String customerName)
	{
		if (customerName == null)
			return false;
		
		customerName = customerName.trim();
		if (customerName.length() == 0)
			return false;

		Customer c = new Customer(customerName);
		return AddCustomer(c);
	}//Create new Customer and add Customer Name to the array list
	
	public boolean AddCustomer (Customer c)
	{
		return customers.add(c);		
	}
	
	public void ViewCustomerList()
	{
		for(int i = 0; i<customers.size(); i++)
		{
			Customer currentCustomer = customers.get(i);
			String curCustomerName = currentCustomer.getName();
			System.out.println(curCustomerName);
		}
	}//print out the array list with a for loop
	
	
	public void SortCustomerList()
	{
		for(int i = 0; i < (customers.size() - 1); i++)
		{
			int j = i + 1;
			int minIdx = i;
			Customer minValue = customers.get(i);
			String minValueName = minValue.getName();
			
			for (; j < customers.size(); j++)// Find the local min value
			{
				Customer cj = customers.get(j);
				
				String customerNamej = cj.getName();
				
				// Check if this is the min value
				int compare = customerNamej.compareToIgnoreCase(minValueName);
				if(compare < 0) //negative result means j < min
				{
					minIdx = j;
					minValue = cj;
					minValueName = minValue.getName();
				}				
			}
			
			
			// If the minIdx is not the same as i, then i is larger
			if (minIdx != i)
			{
				// Swap customers[min] with customers[i]
				String tmpName = customers.get(i).getName();
				customers.get(i).setName(minValueName);
				customers.get(minIdx).setName(tmpName);
			
			}
		}
	}
	
	public Customer FindCustomer(String customerName)
	{
		if (customerName == null)
			return null;
		
		customerName = customerName.trim();
		if (customerName.length() == 0)
			return null;

		
		Customer c = null;
		for(int i = 0; i<customers.size(); i++)
		{
			c = customers.get(i);
			String curCustomerName = c.getName();
			if (curCustomerName.equalsIgnoreCase(customerName))
			{
				return c;
			}
		}
		return null;
	} //Search Customer
	
	public boolean DeleteCustomer (String customerName)
	{
		if (customerName == null)
			return false;
		
		customerName = customerName.trim();
		if (customerName.length() == 0)
			return false;
		
		// 
		for(int i = 0; i<customers.size(); i++)
		{
			Customer currentCustomer = customers.get(i);
			String curCustomerName = currentCustomer.getName();
			if (curCustomerName.equalsIgnoreCase(customerName))
			{
				customers.remove(i);
				return true;
			}
		}
		return false;
	}//Remove Customer if existed
	
	public int TotalCustomer()
	{
		return customers.size();
	}
}
