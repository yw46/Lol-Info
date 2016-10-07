package com.fun.yishuo.lolinfo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fun.yishuo.lolinfo.Model.DataBaseHelper;
import com.fun.yishuo.lolinfo.Model.FileIO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TextActivity extends Activity {

    private String champName, textstr;
    private ImageView ivchampCD,ivearlyitem01CD,ivearlyitem02CD, ivearlyitem03CD;
    private TextView tvchampnameCD, tvchampCD;
    private LinearLayout ll18CD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_text);
//
//        EditText etTest = (EditText) findViewById(R.id.etTest);
//        TextView text = (TextView) findViewById(R.id.tvTest);
//
//        int height = etTest.getLayoutParams().height;
//        int width = etTest.getLayoutParams().width;
//        String tmp = "Jim";
//        String textstr = "Height: " + height + "\nWidth: " + width;
//        text.setText(textstr);


//        setContentView(R.layout.activity_champ_detail);
//        champName = "Aatrox";
//
//        ivchampCD = (ImageView) findViewById(R.id.ivchampCD);
//        ivearlyitem01CD = (ImageView) findViewById(R.id.ivearlyitem01CD);
//        ivearlyitem02CD = (ImageView) findViewById(R.id.ivearlyitem02CD);
//        ivearlyitem03CD = (ImageView) findViewById(R.id.ivearlyitem03CD);
//        tvchampnameCD = (TextView) findViewById(R.id.tvchampnameCD);
//        tvchampCD = (TextView) findViewById(R.id.tvchampCD);
//        ll18CD = (LinearLayout) findViewById(R.id.ll18CD);
//
//        setInitInfo();
//
//        ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) ll18CD.getLayoutParams();
//        params.height = params.width;
//        ivearlyitem01CD.setLayoutParams(params);
//        ivearlyitem02CD.setLayoutParams(params);
//        ivearlyitem03CD.setLayoutParams(params);


        setContentView(R.layout.activity_text);
        EditText etTest = (EditText) findViewById(R.id.etTest);
        TextView text = (TextView) findViewById(R.id.tvTest);
        FileIO fileIO = new FileIO(this, "testFileIO");
        List<String> ar = new ArrayList<>();
        ar = fileIO.readFile();
        String tmpstr = "";
        for (String str : ar) {
            tmpstr += str;
        }
        text.setText(tmpstr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_text, menu);
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


    private void setInitInfo() {
        DataBaseHelper dbHelper = new DataBaseHelper(this, "lolchampinfo.db");

        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            throw new Error("Unable to create db");
        }

        try {
            dbHelper.openDataBase();
        } catch (SQLException e) {
            throw new Error("Unable to open db");
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "SELECT THUMBNAIL, PRIMARY_ROLE, SECONDARY_ROLE, TITLE, NATION, ATTACK, DEFENSE, ABILITY, DIFF, DATE, IP, RP FROM LOLCHAMPINFO WHERE name = \"" + champName + "\"";
        Cursor cursor = db.rawQuery(sql, new String[]{});

        if (cursor.moveToFirst()) {
            byte[] blob = cursor.getBlob(0);
            String primaryRole = cursor.getString(1);
            String secondaryRole = cursor.getString(2);
            String title = cursor.getString(3);
            String nation = cursor.getString(4);
            String attack = cursor.getString(5);
            String defense = cursor.getString(6);
            String ability = cursor.getString(7);
            String diff = cursor.getString(8);
            String date = cursor.getString(9);
            int ip = cursor.getInt(10);
            int rp = cursor.getInt(11);
            // logoImage.setImageBitmap(BitmapFactory.decodeByteArray( currentAccount.accImage,
            //   0,currentAccount.accImage.length));
            ivchampCD.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
            textstr = champName + " (" + primaryRole + ")";
            if (!secondaryRole.isEmpty()) {
                textstr += " (" + secondaryRole + ")";
            }
            textstr += "\n" + title + "\n" + nation;
            tvchampnameCD.setText(textstr);
            textstr = "Attack: " + attack + "\nDefense: " + defense + "\nAbility: " + ability
                    + "\nDifficulty: " + diff;
            tvchampCD.setText(textstr);
        }

        cursor.close();
        db.close();
        dbHelper.close();
    }

}
