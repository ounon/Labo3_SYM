package ch.heigvd.sym.labo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by User on 08.12.2017.
 */

public class LoginActivity extends AppCompatActivity{
    private final static String USERNAME = "iso";
    private final static String PASSWORD = "12345";

    private EditText usernameTxt = null;
    private EditText passwordTxt = null;
    private Button btnConnect = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameTxt = (EditText) findViewById(R.id.text_login);
        passwordTxt = (EditText) findViewById(R.id.text_password);
        btnConnect = (Button) findViewById(R.id.button_nfc);

        btnConnect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (usernameTxt.getText().toString().equals(USERNAME)
                        && passwordTxt.getText().toString().equals(PASSWORD)) {
                    Intent intent = new Intent(LoginActivity.this, NFCActivity.class);
                   // intent.putExtra("emailEntered", mail);
                    startActivity(intent);
                }
            }
        });
    }
}
