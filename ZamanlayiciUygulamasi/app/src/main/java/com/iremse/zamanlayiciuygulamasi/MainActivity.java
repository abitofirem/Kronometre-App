package com.iremse.zamanlayiciuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Chronometer kronometre;
    Button basladur, restart;
    long fark;
    int deger=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        kronometre= findViewById(R.id.kronometre);
        basladur= findViewById(R.id.basladur);
        restart=findViewById(R.id.restart);



// Rengi değiştirmek için kullanacağınız renk
        int color = Color.parseColor("#FB488C"); // Örnek olarak kırmızı rengi seçiyoruz

// Rengi değiştirme
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_IN);

// ImageView'e mipmap'teki görseli yükleme
        imageView.setImageResource(R.mipmap.clock); // "your_mipmap_image" yerine kendi mipmap görselinizin adını yazın


        basladur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deger==0){
                    kronometre.setBase(SystemClock.elapsedRealtime());
                    kronometre.start();
                    basladur.setText("DURDUR");
                    deger=1;
                } else if (deger==1){
                    fark=SystemClock.elapsedRealtime();
                    kronometre.stop();
                    basladur.setText("DEVAM ETTİR");
                    deger=2;
                }else{
                    kronometre.setBase(kronometre.getBase()+SystemClock.elapsedRealtime()-fark);
                    basladur.setText("DURDUR");
                    kronometre.start();
                    deger=1;

                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kronometre.setBase(SystemClock.elapsedRealtime());
                kronometre.start();
                basladur.setText("DURDUR");
                deger=1;

            }
        });
    }
}