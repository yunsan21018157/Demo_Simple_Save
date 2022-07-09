package sg.edu.rp.c346.id21018157.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //step 1: obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //step 2: create a SharedPreferences Editor by calling edit()
        SharedPreferences.Editor prefEdit = prefs.edit();
        //step 3: set a key-value pair in the editor
        prefEdit.putString("greetings", "Hello!");
        //step 4: call commit() to save the changes made to the SharedPreference
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //step 1: obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //step 2: retrieve the saved data from the SharedPreferences
        // with a default value if no matching data
        String msg = prefs.getString("greetings","No greetings name");
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}
