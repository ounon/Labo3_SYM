package ch.heigvd.sym.labo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Auteurs: Ibrahim Ounon & Emmanuel Schmid
 */

public class NfcMainActivity extends AppCompatActivity {
    private Button btnNfcLogin = null;
    private Button btnOnlyNfc = null;
    private Button btnOnlyLogin = null;

    private boolean secondAuthentification; // true s'il faut en plus du login lire le tag NFC avant d'acceder à l'application
                              // false si aprés le login faut acceder directement à l'application

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc_main);

        this.btnNfcLogin = (Button) findViewById(R.id.nfc);
        this.btnOnlyNfc = (Button) findViewById(R.id.only_nfc);
        this.btnOnlyLogin = (Button) findViewById(R.id.only_login);


        btnNfcLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                secondAuthentification = true;
                Intent intent = new Intent(NfcMainActivity.this, LoginActivity.class);
                intent.putExtra("nfcLogin",secondAuthentification);
                startActivity(intent);
            }
        });

        btnOnlyNfc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NfcMainActivity.this, NFCActivity.class);
                startActivity(intent);
            }
        });

        btnOnlyLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                secondAuthentification = false;
                Intent intent = new Intent(NfcMainActivity.this, LoginActivity.class);
                intent.putExtra("onlyLogin",secondAuthentification);
                startActivity(intent);
            }
        });

    }
}
