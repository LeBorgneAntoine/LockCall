package fr.m4103c.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import fr.m4103c.tp3.controller.BackListener;
import fr.m4103c.tp3.controller.RegisterListener;

/**
 * @author Antoine LE BORGNE
 *
 * Activity to let a new user create his own
 * account.
 */
public class RegisterActivity extends AppCompatActivity {

    private ImageView backButton;
    private EditText loginInput;
    private EditText passwordInput;
    private EditText confirmPasswordInput;
    private AppCompatButton registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(getResources().getColor(R.color.primary_color));


        backButton =            (ImageView)         findViewById(R.id.back_arrow);
        loginInput =            (EditText)          findViewById(R.id.login_text);
        passwordInput =         (EditText)          findViewById(R.id.password_text);
        confirmPasswordInput =  (EditText)          findViewById(R.id.password_text2);
        registerButton =        (AppCompatButton)   findViewById(R.id.register_button);



        //adding listener
        backButton.setOnClickListener(new BackListener(this));
        registerButton.setOnClickListener(new RegisterListener(this));
    }


    /**
     * get the string value of the login text field
     *
     * @return the string value
     */
    public String getLoginText(){
        return loginInput.getText().toString();
    }

    /**
     * get the string value of the password text field
     *
     * @return the string value
     */
    public String getPasswordText(){
        return passwordInput.getText().toString();
    }

    /**
     * get the string value of the confirmation password text field
     *
     * @return the string value
     */
    public String getConfirmPasswordText(){
        return confirmPasswordInput.getText().toString();
    }


}