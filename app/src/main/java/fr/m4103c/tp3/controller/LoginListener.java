package fr.m4103c.tp3.controller;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import fr.m4103c.tp3.IdentActivity;
import fr.m4103c.tp3.UnlockActivity;
import fr.m4103c.tp3.db.loginDAO;

/**
 * @author Antoine LE BORGNE
 *
 * check if the logins informations are correct
 * and redirect to the unlock activity
 */
public class LoginListener implements View.OnClickListener {

    private IdentActivity authenticateActivity;


    /**
     * default constructor of the listener
     *
     * @param authenticateActivity the authentication activity
     */
    public LoginListener(IdentActivity authenticateActivity) {
        this.authenticateActivity = authenticateActivity;
    }

    @Override
    public void onClick(View v) {

        String login = authenticateActivity.getLoginText();
        String password = authenticateActivity.getPasswordText();

        if(loginDAO.auth(login,password)) {

            loginDAO.loginPerformed();

            Intent intent = new Intent(authenticateActivity, UnlockActivity.class);
            intent.putExtra("login_name", login);
            authenticateActivity.startActivity(intent);

        }else{

            Toast.makeText(authenticateActivity,"Wrong password or username", Toast.LENGTH_LONG).show();

        }

    }
}
