package pl.edu.pwr.s249248.simracinghelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FuelCalc extends AppCompatActivity {

    float race_length;
    float lap_time_min;
    float lap_time_sec;
    float lap_time_ms;
    int laps;
    float fuel;
    float lap_time;
    float fuel_per_lap;

    EditText race_length_input;
    EditText lap_time_min_input;
    EditText lap_time_sec_input;
    EditText lap_time_ms_input;
    EditText fuel_per_lap_input;
    TextView total_laps;
    TextView minimum_fuel;
    TextView safe_fuel;
    TextView recommended_fuel;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_calc);
        button = findViewById(R.id.btn_calc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    input();
                    calc_lap_time();
                    calc_laps();
                    calc_fuel();
                }
                catch(Exception e){
                    Toast.makeText(FuelCalc.this, R.string.error_data , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void input(){
        race_length_input = findViewById(R.id.race_length_input);
        lap_time_min_input = findViewById(R.id.lap_time_min_input);
        lap_time_sec_input = findViewById(R.id.lap_time_sec_input);
        lap_time_ms_input = findViewById(R.id.lap_time_ms_input);
        fuel_per_lap_input = findViewById(R.id.fuel_per_lap_input);

        race_length = Float.valueOf(race_length_input.getText().toString());
        lap_time_min = Float.valueOf(lap_time_min_input.getText().toString());
        lap_time_sec = Float.valueOf(lap_time_sec_input.getText().toString());
        lap_time_ms = Float.valueOf(lap_time_ms_input.getText().toString());
        fuel_per_lap = Float.valueOf(fuel_per_lap_input.getText().toString());
    }

    protected void calc_lap_time(){
        lap_time = lap_time_min+lap_time_sec/60+lap_time_ms/6000;
    }

    protected void calc_laps(){
        total_laps = findViewById(R.id.total_laps_number);
        laps = (int) (race_length/(lap_time))+1;
        total_laps.setText(String.valueOf(laps));
    }

    protected void calc_fuel(){
        minimum_fuel = findViewById(R.id.minimum_number);
        safe_fuel = findViewById(R.id.safe_number);
        recommended_fuel = findViewById(R.id.recommended_number);

        fuel = ((race_length)/lap_time)*fuel_per_lap+(2*fuel_per_lap);

        minimum_fuel.setText(String.valueOf((int) (laps*fuel_per_lap+1)));
        safe_fuel.setText(String.valueOf((int) (fuel+fuel_per_lap*1.5)));
        recommended_fuel.setText(String.valueOf((int) (fuel+1)));
    }
}