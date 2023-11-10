package com.diva.quis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText NILAI_TUGAS, NILAI_QUIS,NILAI_UTS,NILAI_UAS;
    Button tambah,  bersihkan;
    TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NILAI_TUGAS = (EditText) findViewById(R.id.angka_pertama);
        NILAI_QUIS = (EditText) findViewById(R.id.angka_kedua);
        NILAI_UTS = (EditText) findViewById(R.id.angka_ketiga);
        NILAI_UAS = (EditText) findViewById(R.id.angka_keempat);
        tambah = (Button)findViewById(R.id.tambah);
        bersihkan = (Button) findViewById(R.id.bersihkan);
        hasil = (TextView) findViewById(R.id.hasil);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((NILAI_TUGAS.getText().length()>0) &&
                        (NILAI_QUIS.getText().length()>0) &&
                                (NILAI_UTS.getText().length()>0)&&
                        NILAI_UAS.getText().length()>0)
                {
                    double angka1 =
                            Double.parseDouble(NILAI_TUGAS.getText().toString());
                    double angka2 =
                            Double.parseDouble(NILAI_QUIS.getText().toString());
                    double angka3 =
                            Double.parseDouble(NILAI_UTS.getText().toString());
                    double angka4 =
                            Double.parseDouble(NILAI_UAS.getText().toString());
                    double result = angka1*20/100 + angka2*20/100 + angka3*30/100 +angka4*30/100;
                    hasil.setText(Double.toString(result));
                }
                else {
                    Toast toast= Toast.makeText(MainActivity.this, "Angka pertama,kedua,ketiga,keempat", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });


        bersihkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NILAI_TUGAS.setText("");
                NILAI_QUIS.setText("");
                NILAI_UTS.setText("");
                NILAI_UAS.setText("");
                hasil.setText("0");
                NILAI_TUGAS.requestFocus();
            }
        });
    }
}