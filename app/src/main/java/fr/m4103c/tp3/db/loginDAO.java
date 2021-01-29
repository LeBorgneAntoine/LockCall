package fr.m4103c.tp3.db;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Antoine LE BORGNE
 *
 * simple DAO to manage the database
 */
public class loginDAO {


    private static boolean isLogged = false;

    /**
     * check if the data are able to connect the
     * user to the application
     *
     * @param login the login of the user
     * @param password the password of the user
     * @return true if the user can log false if not
     */
    public static boolean auth(String login, String password){

        return HardCodeDb.getLogins().get(login) !=null && HardCodeDb.getLogins().get(login).equals(password);
    }


    /**
     * create a new user only if every data are correct :
     *  - the user is not already exiting in the database
     *  - the login cannot be empty
     *  - the password have to be at least 8 char long
     *  - the confirm password have to mach with the password
     *
     * @param login the new user login
     * @param password1 the password of the user
     * @param password2 the confirmation of the password
     * @return a list of error text empty if none
     */
    public static ArrayList<String> create(String login, String password1, String password2){

        ArrayList<String> error = new ArrayList<>();

        if(HardCodeDb.getLogins().get(login) != null)error.add("user already exist");
        if(login.length()<1)error.add("you must have a login");
        if(password1.length() < 8)error.add("the password must be at least 8 char");
        if(!password1.equals(password2))error.add("the password don't match");


        if(error.size()==0){
            HardCodeDb.addLogin(login, password1);
        }

        return error;
    }

    /**
     * just to test the application
     */
    public static void fillLoginStart(){

        create("admin","admin12345","admin12345");
        create("user1","user12345","user12345");

    }

    /**
     * when the login is performed the login information
     * is at true
     */
    public static void loginPerformed(){
        isLogged = true;
    }

    /**
     * check if the user is currently logged
     *
     * @return true if the user is logged false if not
     */
    public static boolean isLogged(){
        return isLogged;
    }
}
