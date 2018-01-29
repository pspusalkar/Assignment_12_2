package com.example.poojajoshi.assignment_12_2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // get the button handles
        Button saveButton = findViewById(R.id.button);
        Button showButton = findViewById(R.id.button2);

        // get the edittext handles
        final EditText editText_name = findViewById(R.id.editText);
        final EditText editText_age = findViewById(R.id.editText2);
        final EditText editText_phone = findViewById(R.id.editText3);
        final EditText editText_city = findViewById(R.id.editText4);

        // set the onlclick listener for Save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // fetch the user entered values
                final String name = editText_name.getText().toString();
                final String age = editText_age.getText().toString();
                final String phone = editText_phone.getText().toString();
                final String city = editText_city.getText().toString();

                // save the values to shared preferences
                SharedPreferences.Editor editor = getSharedPreferences("MyPrefFile", MODE_PRIVATE).edit();
                editor.putString("name", name);
                editor.putString("age", age);
                editor.putString("phone", phone);
                editor.putString("city", city);
                editor.apply();

                String finalStr = name + age + phone + city;

                // print the details
                Toast.makeText(getApplicationContext(), finalStr, Toast.LENGTH_SHORT).show();
            }
        });

        // set the onclick listener for show button
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // fetch the data from shared preferences.
                SharedPreferences prefs = getSharedPreferences("MyPrefFile", MODE_PRIVATE);
                String uname = "Name:"+prefs.getString("name", null)+"\n";
                String uage = "Age:"+prefs.getString("age", null)+"\n";
                String uphone = "Phone"+prefs.getString("phone", null)+"\n";
                String ucity = "City:"+prefs.getString("city", null)+"\n";

                String finalStr = uname + uage + uphone + ucity;

                // print the details.
                Toast.makeText(getApplicationContext(), finalStr, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
