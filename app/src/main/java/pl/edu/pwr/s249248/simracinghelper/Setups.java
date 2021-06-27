package pl.edu.pwr.s249248.simracinghelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class Setups extends AppCompatActivity {

    Button btn_add, btn_viewAll;
    EditText et_track_name, et_aero, et_transmission, et_geometry, et_suspension, et_brakes, et_tyres;
    Switch sw_areWetTyresOn;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setups);

        btn_add=findViewById(R.id.btn_add);
        btn_viewAll=findViewById(R.id.btn_view_setups);
        et_track_name=findViewById(R.id.setup_name);
        et_aero=findViewById(R.id.aero);
        et_transmission=findViewById(R.id.transmission);
        et_geometry=findViewById(R.id.geometry);
        et_suspension=findViewById(R.id.suspension);
        et_brakes=findViewById(R.id.brakes);
        et_tyres=findViewById(R.id.tyres);
        sw_areWetTyresOn=findViewById(R.id.switch1);

        databaseHelper = new DatabaseHelper(Setups.this);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetupStorage setupStorage;
                try{
                    setupStorage = new SetupStorage(-1, et_track_name.getText().toString(), et_aero.getText().toString(), et_transmission.getText().toString(), et_geometry.getText().toString(), et_suspension.getText().toString(), et_brakes.getText().toString(), et_tyres.getText().toString(), sw_areWetTyresOn.isChecked());
                    //Toast.makeText(Setups.this, setupStorage.toString() , Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    //Toast.makeText(Setups.this, "Error" , Toast.LENGTH_SHORT).show();
                    setupStorage = new SetupStorage(-1,"Error", "0", "0", "0", "0", "0", "0",false);
                }

                DatabaseHelper databaseHelper = new DatabaseHelper(Setups.this);

                boolean success = databaseHelper.addOne(setupStorage);
                if(success==true)
                {
                    Toast.makeText(Setups.this, "Added", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Setups.this, "Failed, check your data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetupListViewActivity();
            }
        });
    }

    private void openSetupListViewActivity(){
        Intent intent = new Intent(this, SetupsListView.class);
        startActivity(intent);
    }
}