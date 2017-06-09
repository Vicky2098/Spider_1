package com.example.android.lists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

import static android.R.attr.x;
import static android.R.attr.y;
import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText removeText;
    Button addButton;
    Button removeButton;
    ListView listView;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.list_name);
        removeText = (EditText) findViewById(R.id.list_remove_name);

        addButton = (Button) findViewById(R.id.add_item);
        removeButton = (Button) findViewById(R.id.remove_item);
        listView = (ListView) findViewById(R.id.list_view);
        listItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                listItems.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
                editText.setText(null);
            }
        });



            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(removeText.getText().toString().length()==0)
                    {
                        Toast.makeText(MainActivity.this,"Enter a position",Toast.LENGTH_SHORT).show();
                    }

                    else{
                        int x = Integer.parseInt(removeText.getText().toString());
                        if (x >= 1 && x <= listItems.size()) {
                            listItems.remove(x - 1);
                            adapter.notifyDataSetChanged();
                        } else
                            Toast.makeText(MainActivity.this, "No item in this position to remove", Toast.LENGTH_SHORT).show();
                    }
                    removeText.setText(null);
                }

            });


        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent(MainActivity.this, NewActivity.class);
                String message =(String) (listView.getItemAtPosition(position));
                    in.putExtra("key", message);
                    startActivity(in);

        } } );

    }
    }


