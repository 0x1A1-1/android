package com.example.practiceapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] myFavTV = {"Game of Thrones","Arrow","The Vampire Diaries","Vikings",
                "Breaking Bad","Better Call Saul","The Originals","Nashville","And One More"};

        myAdapter arrayAdapter = new myAdapter(this, myFavTV);

        ListView listView = (ListView) findViewById(R.id.listView1);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);

                Toast.makeText(MainActivity.this, "You selected "+selected, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_Menu) {

            DialogFragment myFragment = new MyDIalogFragment();

            myFragment.show(getFragmentManager(),"theDialog");

            return true;
        }else if (id== R.id.exit_the_app){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public void onGetNameClick(View view) {

        Intent getNameScreenIntent = new Intent(this, SecondScreen.class);

        final int result = 1;

        getNameScreenIntent.putExtra("CallingActivity", "MainActivity");

        startActivityForResult(getNameScreenIntent, result);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView userFeedback = (TextView) findViewById(R.id.user_name_message);

        String prefix = (String) getText(R.string.show_name_sent_back);
        Show returnedShow = (Show) data.getSerializableExtra("Name");

        userFeedback.setText(prefix+returnedShow.getName());

    }
}
