package pl.edu.pwr.s249248.simracinghelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {

    Button bug;
    Button donate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        bug = findViewById(R.id.btn_report_bug);
        donate = findViewById(R.id.btn_donate);

        bug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:" + "stachecki.piotr@gmail.com" + "?subject=" + "Feedback" + "&body=" + "");
                intent.setData(data);
                startActivity(intent);
            }
        });

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paypal.com"));
                startActivity(browserIntent);
            }
        });
    }
}