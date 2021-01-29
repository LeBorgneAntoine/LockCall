package fr.m4103c.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.m4103c.tp3.controller.CallListener;
import fr.m4103c.tp3.controller.LoginListener;
import fr.m4103c.tp3.controller.goToRegisterListener;
import fr.m4103c.tp3.db.HardCodeDb;
import fr.m4103c.tp3.db.loginDAO;

/**
 * @author Antoine LE BORGNE
 *
 * Start point of the application.
 * Activity which let the user log into
 * the app by the login and password.
 * He can also go to the register avtivity.
 */
public class IdentActivity extends AppCompatActivity {

    private EditText loginInput;
    private EditText passwordInput;
    private AppCompatButton loginButton;
    private Button callButton;
    private TextView linkRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(getResources().getColor(R.color.primary_color));

        loginInput = (EditText) findViewById(R.id.login_text);
        passwordInput = (EditText) findViewById(R.id.password_text);
        loginButton = (AppCompatButton) findViewById(R.id.login_button);
        callButton = (Button) findViewById(R.id.call_button);
        linkRegister = (TextView) findViewById(R.id.register_link);

        //adding some login test
        loginDAO.fillLoginStart();

        autoFillInput();

        //adding listener
        loginButton.setOnClickListener(new LoginListener(this));
        callButton.setOnClickListener(new CallListener(this));
        linkRegister.setOnClickListener(new goToRegisterListener(this));

    }

    /**
     * auto fill the edit text if the user has
     * just performed a new account creation
     */
    private void autoFillInput(){
        if(getIntent().hasExtra("login_name_auto_fill") && getIntent().hasExtra("password_auto_fill")){
            loginInput.setText(getIntent().getStringExtra("login_name_auto_fill"));
            passwordInput.setText(getIntent().getStringExtra("password_auto_fill"));
        }
    }

    /**
     * get the text of the login input
     *
     * @return a string of the login input
     */
    public String getLoginText(){
        return loginInput.getText().toString();
    }

    /**
     * get the text of the password input
     *
     * @return a string of the password input
     */
    public String getPasswordText(){
        return passwordInput.getText().toString();
    }
}