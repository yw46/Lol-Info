package com.fun.yishuo.lolinfo;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.fun.yishuo.lolinfo.Model.ChampDetail;
import com.fun.yishuo.lolinfo.Model.FileIO;
import com.fun.yishuo.lolinfo.Model.MyListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChampionActivity extends Activity {
    private EditText etChamp;
    private ImageButton ibChampSearch;
    private ListView lvChampChamp;

    private FileIO fileIO;
    private List<String> champList, champAll;
    private MyListAdapter myListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion);

        fileIO = new FileIO(this, "champion_list");
        champList = new ArrayList<>();
        champAll = new ArrayList<>();
        champAll = fileIO.readFile();

        etChamp = (EditText) findViewById(R.id.etChamp);
        ibChampSearch = (ImageButton) findViewById(R.id.ibChampSearch);
        lvChampChamp = (ListView) findViewById(R.id.lvChampChamp);
        showResult("all");

        int btnSize = etChamp.getLayoutParams().height;
        ibChampSearch.setLayoutParams(new LinearLayout.LayoutParams(ibChampSearch.getLayoutParams().width, btnSize));

        myListAdapter = new MyListAdapter(this, R.layout.champ_lv, champList);
        lvChampChamp.setAdapter(myListAdapter);

        etChamp.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    performSearch();
                    return true;
                }
                return false;
            }
        });

        etChamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etChamp.setText("");
            }
        });

        ibChampSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String tmpName = etChamp.getText().toString();
//                showResult(tmpName);
//                int i = champList.size();
//                if (i == 0 ) {
//                    showToast("No Result Found");
//                }
//                myListAdapter = new MyListAdapter(getBaseContext(), R.layout.champ_lv, champList);
//                lvChampChamp.setAdapter(myListAdapter);
//                closeKeyboard();
                performSearch();
            }
        });

        lvChampChamp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tmpName = champList.get(position);
                //ChampDetail cd = new ChampDetail(tmpName);
                Intent intent = new Intent(ChampionActivity.this, ChampDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", tmpName);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_champion, menu);
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

    // hides keyboard
    // Reference: http://stackoverflow.com/questions/3400028/close-virtual-keyboard-on-button-press
    // Author: Mazzy
    private void closeKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void showToast() {
        Toast.makeText(getApplicationContext(), "this is my Toast message!!! =)",
                Toast.LENGTH_LONG).show();
    }

    private void showToast(String str) {
        Toast.makeText(getApplicationContext(), str,
                Toast.LENGTH_LONG).show();
    }

    // changes list of champions
    private void showResult(String champName) {
        champName = champName.toLowerCase();
        if (champName.equals("all") || champName.isEmpty()) {
            champList = champAll;
            return;
        }
        champList = new ArrayList<>();
        for (String tmpName : champAll) {
            if (tmpName.toLowerCase().contains(champName)) {
                champList.add(tmpName);
            }
        }
        return;
    }

    // checks the given name is in the heros list
    private boolean checkName(String champName) {
        if (champName.isEmpty()) {
            return true;
        }
        return false;
    }

    private void performSearch() {
                String tmpName = etChamp.getText().toString();
                showResult(tmpName);
                int i = champList.size();
                if (i == 0 ) {
                    showToast("No Result Found");
                }
                myListAdapter = new MyListAdapter(getBaseContext(), R.layout.champ_lv, champList);
                lvChampChamp.setAdapter(myListAdapter);
                closeKeyboard();
    }
}
