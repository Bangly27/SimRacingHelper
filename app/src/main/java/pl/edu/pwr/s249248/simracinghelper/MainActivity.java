package pl.edu.pwr.s249248.simracinghelper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_calc);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFuelActivity();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetupsActivity();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutActivity();
            }
        });
    }

    public void openFuelActivity(){
        Intent intent = new Intent(this, FuelCalc.class);
        startActivity(intent);
    }

    public void openSetupsActivity(){
        Intent intent = new Intent(this, Setups.class);
        startActivity(intent);
    }

    public void openAboutActivity(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}