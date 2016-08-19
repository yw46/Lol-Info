package com.fun.yishuo.lolinfo.Model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yishuo Wang on 7/22/16.
 * Read text file
 * Reference: http://stackoverflow.com/questions/30417810/reading-from-a-text-file-in-android-studio-java
 * Aurthor: AndyRoid
 */
public class FileIO {
    private Context context;
    private String fileName;

    public FileIO(Context context) {
        this.context = context;
    }

    public FileIO(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> readFile() {
        List<String> textLst = new ArrayList<>();
        AssetManager am = context.getAssets();

        try {
            InputStream is = am.open(fileName);
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = bf.readLine()) != null) {
                textLst.add(line);
            }
            bf.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textLst;
    }
}
