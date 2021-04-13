package Pro;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		ItemMain im = new ItemMain();
		
		int choice;
		do {
			System.out.println("------Main System-----");
			
			System.out.println("1. Item");
			System.out.println("2. Customer");
			System.out.println("3. Order");
			System.out.println("4. Exit");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1 :
				 
				 im.itemMainMenu();
				break;
			case 2:
				// it.displayData();
				 break;
			case 3: 
				break;
			case 4:
				System.out.println("Thank you");
				
			default :
			break;
			}

		}
		
		while(choice!=4);
	}

}
