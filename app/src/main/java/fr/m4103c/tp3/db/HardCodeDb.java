package fr.m4103c.tp3.db;

import java.util.HashMap;

/**
 * @author Antoine LE BORGNE
 *
 * the "database" of the application (hard coded)
 */
public class HardCodeDb {

    private static HashMap<String, String> logins = new HashMap<>();

    /**
     * add login in the hash map
     *
     * @param login the login of the new user
     * @param password the password of hte new user
     */
    public static void addLogin(String login, String password){
        logins.put(login, password);
    }

    /**
     * get the list of login in the database
     *
     * @return the current state of the database
     */
    public static HashMap<String, String> getLogins() {
        return logins;
    }
}
