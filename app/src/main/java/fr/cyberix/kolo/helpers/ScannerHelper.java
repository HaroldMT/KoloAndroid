/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.helpers;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.HashMap;
import java.util.Map;

import static android.hardware.Camera.CameraInfo.CAMERA_FACING_BACK;
import static android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT;

public class ScannerHelper {
    public final static int WIDTH = 500;
    public static int white = 0xFFFFFFFF;

////    To obtain the result, add in onActivityResult.

    //    IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//    if(result != null) {
//        if(result.getContents() == null) {
//            Log.d("MainActivity", "Cancelled scan");
//            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
//        } else {
//            Log.d("MainActivity", "Scanned");
//            Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
//        }
//    }
    public static int black = 0xFF000000;

    public static void scanBarcode(Activity activity, View view) {
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setCameraId(CAMERA_FACING_BACK);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);//Before QR_CODE_TYPES
        integrator.setPrompt("Scan QR Code");
        integrator.setBeepEnabled(true);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }


    public static void scanBarcodeFrontCamera(Activity activity, View view) {
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setCameraId(CAMERA_FACING_FRONT);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);//Before QR_CODE_TYPES
        integrator.setPrompt("Scan QR Code");
        integrator.setBeepEnabled(true);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }

    public static Bitmap generateQRBitMap(final String content) {
        Map<EncodeHintType, ErrorCorrectionLevel> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 512, 512, hints);
            MultiFormatWriter mfw = new MultiFormatWriter();
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {

                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
            return bmp;
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void generateQRCode_general(String data, ImageView img) throws WriterException {
        com.google.zxing.Writer writer = new QRCodeWriter();
        String finaldata = Uri.encode(data, "utf-8");

        BitMatrix bm = writer.encode(finaldata, BarcodeFormat.QR_CODE, 150, 150);
        Bitmap ImageBitmap = Bitmap.createBitmap(150, 150, Bitmap.Config.ARGB_8888);

        for (int i = 0; i < 150; i++) {//width
            for (int j = 0; j < 150; j++) {//height
                ImageBitmap.setPixel(i, j, bm.get(i, j) ? Color.BLACK : Color.WHITE);
            }
        }

        if (ImageBitmap != null) {
            img.setImageBitmap(ImageBitmap);
        }
    }

    static Bitmap encodeAsBitmap(String str) {
        BitMatrix result;
        Bitmap bitmap = null;
        try {
            result = new MultiFormatWriter().encode(str,
                    BarcodeFormat.QR_CODE, WIDTH, WIDTH, null);

            int w = result.getWidth();
            int h = result.getHeight();
            int[] pixels = new int[w * h];
            for (int y = 0; y < h; y++) {
                int offset = y * w;
                for (int x = 0; x < w; x++) {
                    pixels[offset + x] = result.get(x, y) ? black : white;
                }
            }
            bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, 500, 0, 0, w, h);
        } catch (Exception iae) {
            iae.printStackTrace();
            return null;
        }
        return bitmap;
    }
}


