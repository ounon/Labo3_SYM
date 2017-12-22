package ch.heigvd.sym.labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Auteurs: Ibrahim Ounon & Emmanuel Schmid
 */

public class MainActivity extends AppCompatActivity {

    private Button btnNfc = null;
    private Button btnQRCode = null;
    private Button btnIBeacon = null;
    private Button btnCompass = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnNfc = (Button) findViewById(R.id.nfc);
        this.btnQRCode = (Button) findViewById(R.id.qrcode);
        this.btnIBeacon = (Button) findViewById(R.id.ibeacon);
        this.btnCompass = (Button) findViewById(R.id.compass);

        btnNfc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NfcMainActivity.class);
                startActivity(intent);
            }
        });

        btnQRCode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, QRcodeActivity.class);
                startActivity(intent);
            }
        });

        btnIBeacon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, IBeaconActivity.class);
                startActivity(intent);
            }
        });

        btnCompass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CompassActivity.class);
                startActivity(intent);
            }
        });



    }
}
