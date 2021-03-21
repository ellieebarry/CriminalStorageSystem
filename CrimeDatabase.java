/**
 * Class that creates a database to store Crimes
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
import java.util.ArrayList;

public class CrimeDatabase {

    private static CrimeDatabase crimeDatabase;
    ArrayList<Crime> crimeList;

    /**
     * Method that returns a Crime from crimeDatabase
     * @return Crime from CrimeDatabase
     */
    public Crime getCrime(String caseNumber) {
        for(int i=0; i<crimeList.size(); i++)
        {
            if(crimeList.get(i).getcaseID().equals(caseNumber)) return crimeList.get(i);
        }
        return null;
    }

    /**
     * Adds a crime to the databaase
     * @param crime crime to be added
     */
    public void addCrime(Crime crime) {
        crimeList.add(crime);
        for(int i=0; i<crime.getPersonList().size(); i++)
            PersonDatabase.getInstance().addPerson(crime.getPersonList().get(i));
        DataWriter.DataUpdate();
        
    }

   /**
    * Removes a crime from the database
    * @param crime crime to be removed
    */
    public void removeCrime(Crime crime) {
        crimeList.remove(crime);
        DataWriter.DataUpdate();
    }

    /**
     * Method that prints out the crimeDatabase
     */
    public void printDatabase() {
        for (Crime crime : crimeList) {
            System.out.println(crime.toString());
        }
    }

    /**
     * 
     * @return
     */
    public static CrimeDatabase getInstance() {
        if (crimeDatabase == null)
            crimeDatabase = new CrimeDatabase();
        return crimeDatabase;
    }

    /**
     * 
     */
    private CrimeDatabase() {
        this.crimeList = DataLoader.getCrimes();
    }

    /**
     * 
     * @return
     */
    public ArrayList<Crime> getDatabase() {
        return crimeList;
    }

}
