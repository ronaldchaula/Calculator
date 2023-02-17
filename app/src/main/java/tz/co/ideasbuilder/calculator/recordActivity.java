package tz.co.ideasbuilder.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class recordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        Toast.makeText(this,"opened successfully",Toast.LENGTH_SHORT).show();
    }
}