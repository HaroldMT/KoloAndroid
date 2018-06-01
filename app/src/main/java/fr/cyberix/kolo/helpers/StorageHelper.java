/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DecimalFormat;


public final class StorageHelper {
    private static Context mcoContext = KoloHelper.getMyContext();

    public static void writeFileInternal(String sFileName, String sBody, Boolean append) {
        try {
            FileOutputStream outputStream = mcoContext.openFileOutput(sFileName,
                    Context.MODE_PRIVATE);
            outputStream.write(sBody.getBytes());
            outputStream.close();
            File f = mcoContext.getFilesDir();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("writeFile error", e.getMessage());
        }
    }

    public static String readFileInternal(final String sFileName) {
        //Get the text file
        File myFile = new File(mcoContext.getFilesDir().getAbsolutePath() + "/" + sFileName);
        if (!myFile.exists())
            return null;
        //Read text from file
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(myFile));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
            return text.toString();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("readFile", e.getMessage());
        }
        return null;
    }

    public static String readFileInternal1(final String sFileName) {
        BufferedReader input;
        String fileContent = null;
        try {
            File f = mcoContext.getFilesDir();
            File[] fPath0 = f.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File file, String s) {
                    return s.contains(sFileName);
                }
            });
            for (File file : fPath0) {
                if (file.isFile()) {
                    if (file.toString().endsWith(".frs")) {
                        String fName = fPath0[0].getAbsolutePath();
                        FileInputStream fis = mcoContext.openFileInput(sFileName);
                        StringBuffer fileContentBuffer = new StringBuffer("");
                        byte[] byteBuffer = new byte[1024];
                        int n;
                        while ((n = fis.read(byteBuffer)) != -1) {
                            fileContentBuffer.append(new String(byteBuffer, 0, n));
                        }
                        fis.close();
                    }
                }
            }
//            if (fPath0.length > 0) {
//                String fName = fPath0[0].getAbsolutePath();
//                FileInputStream fis = mcoContext.openFileInput(fName);
//                StringBuffer fileContentBuffer = new StringBuffer("");
//                byte[] byteBuffer = new byte[1024];
//                int n;
//                while ((n = fis.read(byteBuffer)) != -1) {
//                    fileContentBuffer.append(new String(byteBuffer, 0, n));
//                }
//                fis.close();
//            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("readFile error", e.getMessage());
        }
        return fileContent;
    }

    public static String readableFileSize(long size) {
        if (size <= 0) return "0";
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    public static void deleteFile(String sFolderName, String sFileName) {
        try {
            mcoContext.deleteFile(sFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap decodeSampledBitmapFromFile(String path,
                                                     int reqWidth, int reqHeight) { // BEST QUALITY MATCH

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Calculate inSampleSize
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        int inSampleSize = 1;

        if (height > reqHeight) {
            inSampleSize = Math.round((float) height / (float) reqHeight);
        }

        int expectedWidth = width / inSampleSize;

        if (expectedWidth > reqWidth) {
            //if(Math.round((float)width / (float)reqWidth) > inSampleSize) // If bigger SampSize..
            inSampleSize = Math.round((float) width / (float) reqWidth);
        }


        options.inSampleSize = inSampleSize;

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(path, options);
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    public Bitmap loadImageFromStorage(String sFolderName, String sFileName) {
        Bitmap bitmapImage = null;
        try {
            File directory = mcoContext.getDir(sFolderName, Context.MODE_PRIVATE);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File file = new File(directory, sFileName);
            bitmapImage = BitmapFactory.decodeStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bitmapImage;
    }

    public void saveToInternalStorage(String sFolderName, String sFileName, Bitmap bitmapImage) {
        File directory = mcoContext.getDir(sFolderName, Context.MODE_PRIVATE);
        File file = new File(directory, sFileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
