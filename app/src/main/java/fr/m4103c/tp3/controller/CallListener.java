package fr.m4103c.tp3.controller;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

import fr.m4103c.tp3.IdentActivity;
import fr.m4103c.tp3.db.loginDAO;

/**
 * @author Antoine LE BORGNE
 *
 * use the listener on button to open the phone dial
 * open the dial only if:
 *  - the user is logged
 *  - a phone number is register
 */
public class CallListener implements View.OnClickListener {


    IdentActivity authenticateActivity;

    /**
     * default constructor of the listener
     *
     * @param authenticateActivity the authentication activity
     */
    public CallListener(IdentActivity authenticateActivity) {
        this.authenticateActivity = authenticateActivity;
    }

    @Override
    public void onClick(View v) {

        if(loginDAO.isLogged()){

            if(authenticateActivity.getIntent().hasExtra("phone_number")) {


                String uri = "tel:" + authenticateActivity.getIntent().getStringExtra("phone_number").trim() ;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                authenticateActivity.startActivity(intent);


            }else{

                Toast.makeText(authenticateActivity,"No phone number selected",Toast.LENGTH_LONG).show();

            }
        }else{
            Toast.makeText(authenticateActivity,"Login first",Toast.LENGTH_LONG).show();
        }

    }
}
