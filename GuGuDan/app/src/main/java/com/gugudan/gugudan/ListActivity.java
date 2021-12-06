package com.gugudan.gugudan;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ArrayAdapter<String> ResultCnt;
    ArrayList<String> RCnt;

    public static final int Start = Menu.FIRST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RCnt = new ArrayList<String>();
        ResultCnt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, RCnt);

        ListView tvC = (ListView)findViewById(R.id.liC);
        tvC.setAdapter(ResultCnt);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        RCnt.add(0,data.getStringExtra("key"));
        ResultCnt.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(Menu.NONE, Start, Menu.NONE, "Start");

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case Start :

                Intent i2 = new Intent();
                i2.setClassName(ListActivity.this, "com.gugudan.gugudan.GuGUDanActivity");
                startActivityForResult(i2, 3);
                break;
        }

        return super.onOptionsItemSelected(item);

    }
}



