package fr.cyberix.kolo.helpers;

import android.net.Uri;

public class QrCodeHelper {
    public static <T> String GenerateQrCodeData(T object, Class<T> typeOfSrc) {
        String jsonContact = SerializationHelper.toJson(object, typeOfSrc);
        String qrData = Uri.encode(jsonContact, "utf-8");
        return qrData;
    }

    public static <T> T GetQrContactFromQrCode(String data, Class<T> typeOfSrc) {
        String jsonObject = Uri.decode(data);
        T object = SerializationHelper.fromJson(jsonObject, typeOfSrc);
        return object;
    }
}
