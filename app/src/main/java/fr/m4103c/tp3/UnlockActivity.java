package fr.m4103c.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import fr.m4103c.tp3.controller.BackListener;
import fr.m4103c.tp3.controller.ValidateListener;

/**
 * @author Antoine LE BORGNE
 *
 * Activity to access the phone number picker
 * and validate.
 */
public class UnlockActivity extends AppCompatActivity {

    private TextView loginName;
    private AppCompatButton validateButton;
    private EditText phoneInput;
    private ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(getResources().getColor(R.color.primary_color));


        loginName = (TextView) findViewById(R.id.login_name);
        validateButton = (AppCompatButton) findViewById(R.id.validate_button);
        phoneInput = (EditText) findViewById(R.id.phone_input);
        back = (ImageView) findViewById(R.id.back);

        String login = getIntent().getStringExtra("login_name");
        loginName.setText(login);


        //set listener
        back.setOnClickListener(new BackListener(this));
        validateButton.setOnClickListener(new ValidateListener(this));

    }


    /**
     * get the string value of the phone number
     *
     * @return the string value
     */
    public String getPhoneNumber(){
        return phoneInput.getText().toString();
    }
}