package Pro;

import java.util.Scanner;

public class ItemMain extends Item {

	Scanner sc = new Scanner(System.in);
	ItemMethod it = new ItemMethod();
	
	public void itemMainMenu() {
	int choice;
	
	do {
		System.out.println("------ITEMS-----");
		
		System.out.println("1. Add new item");
		System.out.println("2. Display the items");
		System.out.println("3. Updating item");
		System.out.println("4. Delete item");
		System.out.println("5. Back to main menu");
		choice=sc.nextInt();
		
		switch(choice) {
		case 1 :
			 
			 it.insertData();
			break;
		case 2:
			 it.displayData();
			 break;
		case 3: 
			 it.updateDate();
			 break;
		case 4:
			 it.deleteData();
			 break;
		case 5: 
			System.out.println("Back to MainMenu");
			
		default :
		break;
		}

	}
	
	while(choice!=5);
}
}
