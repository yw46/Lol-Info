package com.fun.yishuo.lolinfo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fun.yishuo.lolinfo.Model.ChampSkill;
import com.fun.yishuo.lolinfo.Model.DataBaseHelper;
import com.fun.yishuo.lolinfo.Model.FileIO;
import com.fun.yishuo.lolinfo.Model.GlobalFunction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//tvchampnameChampDetail

//TODO Resize image height = width for skill point and item sets
//  look at: http://stackoverflow.com/questions/15425151/change-relative-layout-width-and-height-dynamically
//  for images in item sets, resize layout
//  for images in skill points, resize image
//  resize images in Abilities with hight = width
//  - that is, resize the llabilitiesCD with llabilitiesCD_height = its children's width

public class ChampDetailActivity extends Activity {
    private String textstr, champName;

    private Intent intent;
    private Bundle bundle;

    private ImageView ivchampCD;
    private TextView tvchampnameCD, tvchampCD;

    private LinearLayout llabilitiesCD;
    private ImageView ivpCD, ivqCD, ivwCD, iveCD, ivrCD; // abilities icon
    private TextView tvaNameCD, tvaDescriptionCD; // abilities name and description

    private ImageView iv1CD, iv2CD, iv3CD, iv4CD, iv5CD, iv6CD, iv7CD, iv8CD, iv9CD,
            iv10CD, iv11CD, iv12CD, iv13CD, iv14CD, iv15CD, iv16CD, iv17CD, iv18CD;
    private TextView tv1CD, tv2CD, tv3CD, tv4CD, tv5CD, tv6CD, tv7CD, tv8CD, tv9CD,
            tv10CD, tv11CD, tv12CD, tv13CD, tv14CD, tv15CD, tv16CD, tv17CD, tv18CD;


    private ArrayList<ImageView> alIVs, alIVi;
    private ArrayList<TextView> alTVs;

    private ChampSkill champSkill;



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

        champSkill = GlobalFunction.getChampSkill(this, champName);;

        setupVariable();
        setInitInfo();

        tvaNameCD.setText(champSkill.getPname());
        tvaDescriptionCD.setText(champSkill.getP());

        ivchampCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "ivchampChampDetail", Toast.LENGTH_SHORT).show();
                //textstr += " (Tank)";
                //tvchampnameChampDetail.setText(textstr);
                alIVs.get(0).setImageResource(R.drawable.champ_amumu_square);
            }
        });

        //TODO all(5) onClick event into one function

        ivpCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tvaNameCD, tvaDescriptionCD
                setSkillDescription("p");
            }
        });

        ivqCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tvaNameCD, tvaDescriptionCD
                setSkillDescription("q");
            }
        });

        ivwCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tvaNameCD, tvaDescriptionCD
                setSkillDescription("w");
            }
        });

        iveCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tvaNameCD, tvaDescriptionCD
                setSkillDescription("e");
            }
        });

        ivrCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tvaNameCD, tvaDescriptionCD
                setSkillDescription("r");
            }
        });

        alIVs.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "testArrayListClick", Toast.LENGTH_LONG).show();
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
        } else if (id == R.id.action_urlDuowan) {
            // Reference: http://stackoverflow.com/questions/5026349/how-to-open-a-website-when-a-button-is-clicked-in-android-application
            // Author: Alain Pannetier
            String url = "http://lol.duowan.com/" + champName.toLowerCase();
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            /*

    public void goToSu (View view) {
        goToUrl ( "http://superuser.com/");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
             */
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
        //------------------------------------------------------------------------------
        // Setup Skill icon
        dbHelper = new DataBaseHelper(this, "lolchampskill.db");

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

        db = dbHelper.getWritableDatabase();
        sql = "SELECT pthumbnail, qthumbnail, wthumbnail, ethumbnail, rthumbnail, " +
                "skillorder, itemsetearly, itemsetmid, itemsetlate0, itemsetlate1" +
                " FROM LOLCHAMPSKILL WHERE champ = \"" + champName + "\"";
        cursor = db.rawQuery(sql, new String[]{});

        byte[] blob;
        // use if or for
        if (cursor.moveToFirst()) {
            blob = cursor.getBlob(0);
            ivpCD.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
            champSkill.addSkillImage(blob);
            blob = cursor.getBlob(1);
            ivqCD.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
            champSkill.addSkillImage(blob);
            blob = cursor.getBlob(2);
            ivwCD.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
            champSkill.addSkillImage(blob);
            blob = cursor.getBlob(3);
            iveCD.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
            champSkill.addSkillImage(blob);
            blob = cursor.getBlob(4);
            ivrCD.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
            champSkill.addSkillImage(blob);
            champSkill.setSkillOrder(cursor.getString(9));
        }

        // not working
//        byte[] blob;
//        for (int i = 0; i < 5; i++) {
//            blob = cursor.getBlob(i);
//            champSkill.addSkillImage(blob);
//        }
//
//        blob = champSkill.getImage('p');
//        ivpCD.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
//        blob = champSkill.getImage('q');
//        ivqCD.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
//        blob = champSkill.getImage('w');
//        ivwCD.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
//        blob = champSkill.getImage('e');
//        iveCD.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
//        blob = champSkill.getImage('r');
//        ivrCD.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));

        cursor.close();
        db.close();
        dbHelper.close();

        //Toast.makeText(getApplicationContext(), String.valueOf(champSkill.getSkillImage().size()), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), champSkill.getSkillOrder(), Toast.LENGTH_SHORT).show();
        blob = champSkill.getImage('p');
        alIVs.get(0).setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
    }

    private void setupVariable() {
        ivchampCD = (ImageView) findViewById(R.id.ivchampCD);
        ivpCD = (ImageView) findViewById(R.id.ivpCD);
        ivqCD = (ImageView) findViewById(R.id.ivqCD);
        ivwCD = (ImageView) findViewById(R.id.ivwCD);
        iveCD = (ImageView) findViewById(R.id.iveCD);
        ivrCD = (ImageView) findViewById(R.id.ivrCD);

        tvchampnameCD = (TextView) findViewById(R.id.tvchampnameCD);
        tvchampCD = (TextView) findViewById(R.id.tvchampCD);
        tvaNameCD = (TextView) findViewById(R.id.tvaNameCD);
        tvaDescriptionCD = (TextView) findViewById(R.id.tvaDescriptionCD);

        alIVs = new ArrayList<>();
        alIVi = new ArrayList<>();
        alTVs = new ArrayList<>();
        // alIVs -> Skill Point
        alIVs.add((ImageView) findViewById(R.id.iv1CD));
        alIVs.add((ImageView) findViewById(R.id.iv2CD));
        alIVs.add((ImageView) findViewById(R.id.iv3CD));
        alIVs.add((ImageView) findViewById(R.id.iv4CD));
        alIVs.add((ImageView) findViewById(R.id.iv5CD));
        alIVs.add((ImageView) findViewById(R.id.iv6CD));
        alIVs.add((ImageView) findViewById(R.id.iv7CD));
        alIVs.add((ImageView) findViewById(R.id.iv8CD));
        alIVs.add((ImageView) findViewById(R.id.iv9CD));
        alIVs.add((ImageView) findViewById(R.id.iv10CD));
        alIVs.add((ImageView) findViewById(R.id.iv11CD));
        alIVs.add((ImageView) findViewById(R.id.iv12CD));
        alIVs.add((ImageView) findViewById(R.id.iv13CD));
        alIVs.add((ImageView) findViewById(R.id.iv14CD));
        alIVs.add((ImageView) findViewById(R.id.iv15CD));
        alIVs.add((ImageView) findViewById(R.id.iv16CD));
        alIVs.add((ImageView) findViewById(R.id.iv17CD));
        alIVs.add((ImageView) findViewById(R.id.iv18CD));
        // alTVs -> Skill Point
        alTVs.add((TextView) findViewById(R.id.tv1CD));
        alTVs.add((TextView) findViewById(R.id.tv2CD));
        alTVs.add((TextView) findViewById(R.id.tv3CD));
        alTVs.add((TextView) findViewById(R.id.tv4CD));
        alTVs.add((TextView) findViewById(R.id.tv5CD));
        alTVs.add((TextView) findViewById(R.id.tv6CD));
        alTVs.add((TextView) findViewById(R.id.tv7CD));
        alTVs.add((TextView) findViewById(R.id.tv8CD));
        alTVs.add((TextView) findViewById(R.id.tv9CD));
        alTVs.add((TextView) findViewById(R.id.tv10CD));
        alTVs.add((TextView) findViewById(R.id.tv11CD));
        alTVs.add((TextView) findViewById(R.id.tv12CD));
        alTVs.add((TextView) findViewById(R.id.tv13CD));
        alTVs.add((TextView) findViewById(R.id.tv14CD));
        alTVs.add((TextView) findViewById(R.id.tv15CD));
        alTVs.add((TextView) findViewById(R.id.tv16CD));
        alTVs.add((TextView) findViewById(R.id.tv17CD));
        alTVs.add((TextView) findViewById(R.id.tv18CD));
        // alIVi -> Item Set
        alIVi.add((ImageView) findViewById(R.id.ivearlyitem01CD));
        alIVi.add((ImageView) findViewById(R.id.ivearlyitem02CD));
        alIVi.add((ImageView) findViewById(R.id.ivearlyitem03CD));
        alIVi.add((ImageView) findViewById(R.id.ivmiditem01CD));
        alIVi.add((ImageView) findViewById(R.id.ivmiditem02CD));
        alIVi.add((ImageView) findViewById(R.id.ivmiditem03CD));
        alIVi.add((ImageView) findViewById(R.id.ivmiditem04CD));
        alIVi.add((ImageView) findViewById(R.id.ivlateitem01CD));
        alIVi.add((ImageView) findViewById(R.id.ivlateitem02CD));
        alIVi.add((ImageView) findViewById(R.id.ivlateitem03CD));
        alIVi.add((ImageView) findViewById(R.id.ivlateitem04CD));
        alIVi.add((ImageView) findViewById(R.id.ivlateitem05CD));
        alIVi.add((ImageView) findViewById(R.id.ivlateitem06CD));
        alIVi.add((ImageView) findViewById(R.id.ivlateitem201CD));
        alIVi.add((ImageView) findViewById(R.id.ivlateitem202CD));
        alIVi.add((ImageView) findViewById(R.id.ivlateitem203CD));
        alIVi.add((ImageView) findViewById(R.id.ivlateitem204CD));
        alIVi.add((ImageView) findViewById(R.id.ivlateitem205CD));
        alIVi.add((ImageView) findViewById(R.id.ivlateitem206CD));
    }

    private void setSkillDescription(String option) {
        switch(option) {
            case "p":
                tvaNameCD.setText(champSkill.getPname());
                tvaDescriptionCD.setText(GlobalFunction.getNewLine(champSkill.getP()));
                break;
            case "q":
                tvaNameCD.setText(champSkill.getQname());
                tvaDescriptionCD.setText(GlobalFunction.getNewLine(champSkill.getQ()));
                break;
            case "w":
                tvaNameCD.setText(champSkill.getWname());
                tvaDescriptionCD.setText(GlobalFunction.getNewLine(champSkill.getW()));
                break;
            case "e":
                tvaNameCD.setText(champSkill.getEname());
                tvaDescriptionCD.setText(GlobalFunction.getNewLine(champSkill.getE()));
                break;
            case "r":
                tvaNameCD.setText(champSkill.getRname());
                tvaDescriptionCD.setText(GlobalFunction.getNewLine(champSkill.getR()));
                break;
            default:
                tvaNameCD.setText(champSkill.getPname());
                tvaDescriptionCD.setText(GlobalFunction.getNewLine(champSkill.getP()));
                break;
        }
        return;
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
