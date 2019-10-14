package org.customer.app;

import java.util.List;
import java.util.Scanner;

import org.customer.app.factory.CustomerFactory;
import org.customer.app.factory.CustomerFactoryImpl;
import org.customer.app.model.Customer;

public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try {

			
			int choice;
			do {
				System.out.println("enter your choice");
				System.out.println("1.add the datail");
				System.out.println("2.display the detail");
				System.out.println("3.Search the details");
				System.out.println("4.update the details");
				System.out.println("5.delete the details");
				System.out.println("0. Exit");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.print("ID: ");
					int id = scanner.nextInt();
					System.out.print("NAME: ");
					String name = scanner.next();
					System.out.print("EMAIL: ");
					String email = scanner.next();

					CustomerFactory impl = new CustomerFactoryImpl();
					Customer customer = impl.createCustomer(id, name, email);
					System.out.println(customer.toString());
					break;

				case 2:
					CustomerFactory imp2 = new CustomerFactoryImpl();
					List<Customer> list = imp2.getAllCustomer();
					for (Customer c : list) {
						System.out.println(c);
					}
					break;
				case 3:
					CustomerFactory imp3 = new CustomerFactoryImpl();
					System.out.print("enter id to search: ");
					id = scanner.nextInt();
					imp3.findById(id);
					break;

				case 4:
					CustomerFactory imp4 = new CustomerFactoryImpl();
					System.out.print("enter id to update");
					id = scanner.nextInt();
					imp4.updateCustomer(id);
					break;
				case 5:
					CustomerFactory imp5 = new CustomerFactoryImpl();
					System.out.print("enter id to delete");
					id = scanner.nextInt();
					imp5.deleteCustomer(id);
					break;

				case 0:
					System.out.println("end !");
					System.exit(0);
				default:
					System.out.println("invalid choice..");
					break;
				}

			} while (choice != 0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		}

	
