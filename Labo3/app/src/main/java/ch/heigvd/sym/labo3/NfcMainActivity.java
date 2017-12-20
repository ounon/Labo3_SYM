package ch.heigvd.sym.labo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by User on 20.12.2017.
 */

public class NfcMainActivity extends AppCompatActivity {
    private Button btnNfcLogin = null;
    private Button btnOnlyNfc = null;
    private Button btnOnlyLogin = null;

    private boolean nfcLogin;
  /*  private boolean onlyLogin;
    private boolean onlyNfc;*/


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
                nfcLogin = true;
                Intent intent = new Intent(NfcMainActivity.this, LoginActivity.class);
                intent.putExtra("nfcLogin",nfcLogin);
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
                nfcLogin = false;
                Intent intent = new Intent(NfcMainActivity.this, LoginActivity.class);
                intent.putExtra("onlyLogin",nfcLogin);
                startActivity(intent);
            }
        });

    }
}