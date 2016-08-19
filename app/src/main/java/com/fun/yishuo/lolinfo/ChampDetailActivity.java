package com.fun.yishuo.lolinfo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fun.yishuo.lolinfo.Model.DataBaseHelper;
import com.fun.yishuo.lolinfo.Model.FileIO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//tvchampnameChampDetail

//TODO Resize image height = width for skill point and item sets
//  look at: http://stackoverflow.com/questions/15425151/change-relative-layout-width-and-height-dynamically

public class ChampDetailActivity extends Activity {
    private String textstr, champName;

    private ImageView ivchampChampDetail;
    private TextView tvchampnameChampDetail, tvchampChampDetail;

    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champ_detail);

        intent = getIntent();
        bundle = intent.getExtras();
        if (!bundle.isEmpty()) {
            textstr = bundle.getString("name");
        } else {
            textstr = "noChamp";
        }
        champName = textstr;

        ivchampChampDetail = (ImageView) findViewById(R.id.ivchampChampDetail);
        tvchampnameChampDetail = (TextView) findViewById(R.id.tvchampnameChampDetail);
        tvchampChampDetail = (TextView) findViewById(R.id.tvchampChampDetail);

        setInitInfo();

        ivchampChampDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "this is my Toast message!!! =)", Toast.LENGTH_LONG).show();
                //textstr += " (Tank)";
                //tvchampnameChampDetail.setText(textstr);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_champ_detail, menu);
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
        Cursor cursor = db.rawQuery(sql, new String[] {});

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
            ivchampChampDetail.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
            textstr = champName + " (" + primaryRole + ")";
            if (!secondaryRole.isEmpty()) {
                textstr += " (" + secondaryRole + ")";
            }
            textstr += "\n" + title + "\n" + nation;
            tvchampnameChampDetail.setText(textstr);
            textstr = "Attack: " + attack + "\nDefense: " + defense + "\nAbility: " + ability
                    + "\nDifficulty: " + diff;
            tvchampChampDetail.setText(textstr);
        }

        cursor.close();
        db.close();
        dbHelper.close();
    }

    /*
    public Account getCurrentAccount() {
    SQLiteDatabase db       =   dbHelper.getWritableDatabase();
    String sql              =   "SELECT * FROM ACCOUNTS";
    Cursor cursor           =   db.rawQuery(sql, new String[] {});

    if(cursor.moveToFirst()){
        this.accId             = cursor.getInt(0);
        this.accName           = cursor.getString(1);
        this.accImage          = cursor.getBlob(2);
    }
    if (cursor != null && !cursor.isClosed()) {
        cursor.close();
    }
    db.close();
    if(cursor.getCount() == 0){
        return null;
    } else {
        return this;
    }
}

logoImage.setImageBitmap(BitmapFactory.decodeByteArray( currentAccount.accImage,
        0,currentAccount.accImage.length));
     */

    /*


http://stackoverflow.com/questions/7331310/how-to-store-image-as-blob-in-sqlite-how-to-retrieve-it

Author: blessenm

Here the code i used for my app

This code will take a image from url and convert is to a byte array

byte[] logoImage = getLogoImage(IMAGEURL);

private byte[] getLogoImage(String url){
     try {
             URL imageUrl = new URL(url);
             URLConnection ucon = imageUrl.openConnection();

             InputStream is = ucon.getInputStream();
             BufferedInputStream bis = new BufferedInputStream(is);

             ByteArrayBuffer baf = new ByteArrayBuffer(500);
             int current = 0;
             while ((current = bis.read()) != -1) {
                     baf.append((byte) current);
             }

             return baf.toByteArray();
     } catch (Exception e) {
             Log.d("ImageManager", "Error: " + e.toString());
     }
     return null;
}

To save the image to db i used this code.

    public void insertUser(){
    SQLiteDatabase db               =   dbHelper.getWritableDatabase();

    String delSql                       =   "DELETE FROM ACCOUNTS";
    SQLiteStatement delStmt         =   db.compileStatement(delSql);
    delStmt.execute();

    String sql                      =   "INSERT INTO ACCOUNTS (account_id,account_name,account_image) VALUES(?,?,?)";
    SQLiteStatement insertStmt      =   db.compileStatement(sql);
    insertStmt.clearBindings();
    insertStmt.bindString(1, Integer.toString(this.accId));
    insertStmt.bindString(2,this.accName);
    insertStmt.bindBlob(3, this.accImage);
    insertStmt.executeInsert();
    db.close();
}

To retrieve the image back this is code i used.

public Account getCurrentAccount() {
    SQLiteDatabase db       =   dbHelper.getWritableDatabase();
    String sql              =   "SELECT * FROM ACCOUNTS";
    Cursor cursor           =   db.rawQuery(sql, new String[] {});

    if(cursor.moveToFirst()){
        this.accId             = cursor.getInt(0);
        this.accName           = cursor.getString(1);
        this.accImage          = cursor.getBlob(2);
    }
    if (cursor != null && !cursor.isClosed()) {
        cursor.close();
    }
    db.close();
    if(cursor.getCount() == 0){
        return null;
    } else {
        return this;
    }
}

logoImage.setImageBitmap(BitmapFactory.decodeByteArray( currentAccount.accImage,
        0,currentAccount.accImage.length));


     */
}
