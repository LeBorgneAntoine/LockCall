package fr.m4103c.tp3.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import fr.m4103c.tp3.IdentActivity;
import fr.m4103c.tp3.UnlockActivity;

/**
 * @author Antoine LE BORGNE
 * listener to be implement to a back button,
 * will get back to the previous activity
 */
public class BackListener implements View.OnClickListener{

    Activity activity;

    /**
     * default constructor of the listener
     *
     * @param activity the current displayed activity
     */
    public BackListener(Activity activity) {
        this.activity =activity;
    }

    @Override
    public void onClick(View v) {

        activity.onBackPressed();

    }
}
