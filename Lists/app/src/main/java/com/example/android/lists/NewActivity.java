package com.example.android.lists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        String message = getIntent().getStringExtra("key").toString(); // Now, message has Drawer title
        setTitle(message);

        TextView item = (TextView) findViewById(R.id.new_item);
        item.setText(message);

    }
}
