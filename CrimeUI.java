import java.util.Scanner;

/**
 * @description creates the main driver of CrimeUI
 * @author Bradley Grose, Ellie Barry, David Keen, David Morrison
 */
public class CrimeUI {

    private static final String WELCOME_MSG = "Welcome to the Criminal Storage System!: Please login";
    private String[] mainMenuOptions = {"Add Crime", "Search Crime", "Modify Crime", "Print Crimes", "Search Criminal", "Modify Criminal", "Print Criminals", "Logout"} ;
    private Scanner scanner;
    private Facade crimeFacade;

    CrimeUI(){
        scanner = new Scanner(System.in);
        crimeFacade = new Facade();
    }
    
    /* 
    * Method that will run the program
    */
    public void run() 
    {
        System.out.println(WELCOME_MSG);

        login();

        while(true) {
            displayMenu();

            int command = getCommand(mainMenuOptions.length);

            if(command == -1) {
				System.out.println("Not a valid option");
				continue;
            }
            
            if(command == mainMenuOptions.length -1) {
				break;
            }

            switch(command) {
                case(0):
                    addCrime();
                    break;
                case(1):
                    searchCrime();
                    break;
                case(2):
                    modifyCrime();
                    break;
                case(3):
                    printCrimes();
                    break;
                case(4):
                    searchCriminal();
                    break;
                case(5):
                    modifyCriminal();
                    break;
                case(6):
                    printCriminals();
                    break;
            }
            
        }
        System.out.println("Logging Out......Complete. Have a good day");
    }

    private int getCommand(int numCommands) {
		System.out.print("What would you like to do?: ");
		
		String input = scanner.nextLine();
		int command = Integer.parseInt(input) - 1;
		
		if(command >= 0 && command <= numCommands -1) return command;
		
		return -1;
	}

    private void login()
    {

    }

    /* 
    * Method that will open the Main menu
    */
    private void displayMenu() 
    {
        System.out.println("\n************ Main Menu *************");
		for(int i=0; i< mainMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + mainMenuOptions[i]);
		}
		System.out.println("\n");
    }

    /* 
    * Method that will open the Admin menu
    */
    private void displayAdmin() 
    {

    }

    private void addCrime() 
    {
        System.out.println("\n------------- adding crime -------------");
    }

    private void searchCrime() 
    {
        System.out.println("\n------------- searching crime -------------");
        String crime = getUserCrime();

        if(crime == null)return;

        if(!crimeFacade.searchCrime(crime)) 
        {
            System.out.println("Sorry the type of crime is not found \n");
            return;
        }

        System.out.println("The crime you're looking for is in library\n");		
    }
    

    private void modifyCrime() 
    {
        System.out.println("\n------------- editing crime -------------");
    }

    private void printCrimes() 
    {
        System.out.println("\n------------- printing crimes -------------");
    }

    private void searchCriminal() 
    {
        System.out.println("\n------------- searching criminal -------------");
        String criminal = getUserCriminal();

        if(criminal == null)return;

        if(!crimeFacade.searchCriminal(criminal)) 
        {
            System.out.println("Sorry the criminal your searching is not found \n");
            return;
        }

        System.out.println("The criminal you're looking for is in library\n");	
    }

    private void printCriminal() 
    {
        System.out.println("\n------------- searching criminal -------------");
    }

    private void removeCrimes() 
    {
        System.out.println("\n------------- removing crime -------------");
    }

    private void addUser() 
    {
        System.out.println("\n------------- adding user -------------");
    }

    private void removeUser() 
    {
        System.out.println("\n------------- removing user -------------");
    }

    private String getUserCrime() 
    {
        System.out.print("Enter User Crimes: ");

        while(true) 
        {
            String crimeName = scanner.nextLine().trim().toLowerCase();

            if(!crimeName.contentEquals("")) return crimeName;

            System.out.println("You need to enter the actual content");
            System.out.print("Would you like to enter crime again (y) or return to main menu (n): ");
            String command = scanner.nextLine().trim().toLowerCase();
            if(command == "n") return null;
        }
    }

    private String getUserCriminal() 
    {
        System.out.print("Enter User Criminals: ");

        while(true) 
        {
            String criminalName = scanner.nextLine().trim().toLowerCase();

            if(!criminalName.contentEquals("")) return criminalName;

            System.out.println("You need to enter the actual content");
            System.out.print("Would you like to enter criminal again (y) or return to main menu (n): ");
            String command = scanner.nextLine().trim().toLowerCase();
            if(command == "n") return null;
        }
    }
    public static void main(String[] args) 
    {
        CrimeUI crimeInterface = new CrimeUI();
        crimeInterface.run();
    }

}
