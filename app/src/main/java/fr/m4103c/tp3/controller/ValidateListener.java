package fr.m4103c.tp3.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.ActivityOptionsCompat;

import fr.m4103c.tp3.IdentActivity;
import fr.m4103c.tp3.UnlockActivity;

/**
 * @author Antoine LE BORGNE
 *
 * Validate the phone number typed on the
 * field only if:
 *  - the number has a lenght of 10
 *  - the phone number is not empty
 */
public class ValidateListener implements View.OnClickListener {

    private UnlockActivity unlockActivity;

    /**
     * Default constructor of the listener
     *
     * @param unlockActivity the unlocked activity
     */
    public ValidateListener(UnlockActivity unlockActivity) {
        this.unlockActivity = unlockActivity;
    }

    @Override
    public void onClick(View v) {

        String phoneNumber = unlockActivity.getPhoneNumber();

        if(!phoneNumber.equals("")){

            if(phoneNumber.length() == 10){
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(unlockActivity,android.R.anim.fade_in, android.R.anim.fade_out).toBundle();

                Intent intent = new Intent(unlockActivity, IdentActivity.class);
                intent.putExtra("phone_number", phoneNumber);
                unlockActivity.startActivity(intent, bundle);
            }else{
                Toast.makeText(unlockActivity, "Invalid phone number",Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(unlockActivity, "No phone number selected",Toast.LENGTH_SHORT).show();
        }

    }
}
