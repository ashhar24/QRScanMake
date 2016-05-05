package com.noc.qrscanmake.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.noc.qrscanmake.R;

import java.util.Hashtable;

/*
 * Created by defoliate on 18-10-2015.
 */
public class GenerateQR extends Activity
{
    private ImageView imgQR;
    private Bitmap img;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generateqr);
        imgQR = (ImageView) findViewById(R.id.imgQR);
        try
        {
            img = generateQrCode("fuk u bitches");
        }
        catch(WriterException e)
        {
            e.printStackTrace();
        }
        imgQR.setImageBitmap(img);
    }

    public static Bitmap generateQrCode (String myCodeText) throws WriterException
    {
        Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H); // H = 30% damage

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        int size = 512;

        BitMatrix bitMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
        //RGB_565  	Each pixel is stored on 2 bytes and only the RGB channels are encoded: red is stored with 5 bits of precision (32 possible values),
        // green is stored with 6 bits of precision (64 possible values) and blue is stored with 5 bits of precision.
        Bitmap bmp = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565);
        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
            }
        }
        return bmp;
    }
}
