package fr.m4103c.tp3.controller;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import fr.m4103c.tp3.IdentActivity;
import fr.m4103c.tp3.RegisterActivity;
import fr.m4103c.tp3.db.loginDAO;

/**
 * @author Antoine LE BORGNE
 *
 * Verifying if the information data can
 * create a new login.
 */
public class RegisterListener implements View.OnClickListener {

    RegisterActivity registerActivity;


    /**
     * default constructor of the listener
     *
     * @param registerActivity the register activity
     */
    public RegisterListener(RegisterActivity registerActivity) {
        this.registerActivity = registerActivity;
    }

    @Override
    public void onClick(View v) {

        String login = registerActivity.getLoginText();
        String password = registerActivity.getPasswordText();
        String confirmPassword = registerActivity.getConfirmPasswordText();

        ArrayList<String> errors = loginDAO.create(login, password, confirmPassword);

        if(errors.size() > 0) {
            StringBuilder message = new StringBuilder();

            for (String error : errors) {
                message.append("- ").append(error).append("\n");
            }


            Toast.makeText(registerActivity, message.toString(), Toast.LENGTH_LONG).show();
        }else{

            Intent intent = new Intent(registerActivity, IdentActivity.class);
            intent.putExtra("login_name_auto_fill", login);
            intent.putExtra("password_auto_fill", password);
            registerActivity.startActivity(intent);

        }

    }
}
