package fr.m4103c.tp3.controller;

import android.content.Intent;
import android.view.View;

import fr.m4103c.tp3.IdentActivity;
import fr.m4103c.tp3.RegisterActivity;

/**
 * @author Antoine LE BORGNE
 *
 * redirect to the register activity
 */
public class goToRegisterListener implements View.OnClickListener {

    private IdentActivity identActivity;

    /**
     * default constructor of the listener
     *
     * @param identActivity the
     */
    public goToRegisterListener(IdentActivity identActivity) {
        this.identActivity = identActivity;
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(identActivity, RegisterActivity.class);
        if(!identActivity.getLoginText().equals("")){
            intent.putExtra("login_name_auto_fill",identActivity.getLoginText());
        }
        identActivity.startActivity(intent);

    }
}
