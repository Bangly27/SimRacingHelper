package pl.edu.pwr.s249248.simracinghelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SetupsListView extends AppCompatActivity {

    ListView lv_new;
    DatabaseHelper databaseHelper;
    ArrayAdapter setupsArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setups_list_view);
        lv_new = findViewById(R.id.lv_new);

        databaseHelper = new DatabaseHelper(SetupsListView.this);
        ShowSetupOnListView(databaseHelper);

        lv_new.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SetupsListView.this, R.string.hold, Toast.LENGTH_SHORT).show();
            }
        });

        lv_new.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SetupStorage clickedSetup = (SetupStorage) parent.getItemAtPosition(position);
                databaseHelper.deleteOne(clickedSetup);
                ShowSetupOnListView(databaseHelper);
                Toast.makeText(SetupsListView.this, R.string.deleted, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void ShowSetupOnListView(DatabaseHelper databaseHelper2) {
        setupsArrayAdapter = new ArrayAdapter<SetupStorage>(SetupsListView.this, android.R.layout.simple_list_item_1, databaseHelper2.selectAll());
        lv_new.setAdapter(setupsArrayAdapter);
    }
}