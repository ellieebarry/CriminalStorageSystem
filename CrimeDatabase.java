
/**
 * @description Class that creates a database to store Crimes
 * @author Bradley Grose, Eleanor Barry, David Keen, David Morrison
 */
import java.util.*;

public class CrimeDatabase {

    private static CrimeDatabase crimeDatabase;
    ArrayList<Crime> crimeList;


    /**
     * Method that returns a Crime from crimeDatabase
     * @return Crime from CrimeDatabase
     */
    public Crime getCrime() {
        Crime crime = new Crime();
        return crime;
    }

    /**
     * Method that adds a Crime to crimeDatabase
     */
    public void addCrime(Crime crime) {

    }

    /**
     * Method that removes a Crime from crimeDatabase
     */
    public void removeCrime(Crime crime) {

    }

    /**
     * Method that modifies a Crime in crimeDatabase
     */
    public void modifyCrime(Crime crime) {

    }

    /**
     * Method that prints out the crimeDatabase
     */
    public void printDatabase() {

    }

    public static CrimeDatabase getInstance()
    {
        if(crimeDatabase == null) crimeDatabase = new CrimeDatabase();
        return crimeDatabase;
    }

    private CrimeDatabase()
    {
        crimeList = DataLoader.getCrimes();
    }

    public ArrayList<Crime> getDatabase()
    {
        return crimeList;
    }
    

}
