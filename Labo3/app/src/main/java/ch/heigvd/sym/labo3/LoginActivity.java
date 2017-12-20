package ch.heigvd.sym.labo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Auteurs: Ibrahim Ounon & Emmanuel Schmid
 */

public class LoginActivity extends AppCompatActivity{
    private final static String USERNAME = "iso";
    private final static String PASSWORD = "12345";

    private EditText usernameTxt = null;
    private EditText passwordTxt = null;
    private Button btnConnect = null;
    private Bundle b;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b = getIntent().getExtras();

        usernameTxt = (EditText) findViewById(R.id.text_login);
        passwordTxt = (EditText) findViewById(R.id.text_password);
        btnConnect = (Button) findViewById(R.id.button_nfc);

        btnConnect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (usernameTxt.getText().toString().equals(USERNAME)
                        && passwordTxt.getText().toString().equals(PASSWORD)) {
                    if (b.getBoolean("secondAuthentification")) {
                        Intent intent = new Intent(LoginActivity.this, NFCActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
