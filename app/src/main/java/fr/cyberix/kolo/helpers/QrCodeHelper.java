package fr.cyberix.kolo.helpers;

import fr.cyberix.kolo.model.QrContact;

public class QrCodeHelper {
    public static String GenerateQrCodeData() {
        QrContact me = new QrContact();
        return SerializationHelper.toJson(me, QrContact.class);
    }

    public static QrContact GetDataFromQrCode(String qrCodeData) {
        return SerializationHelper.fromJson(qrCodeData, QrContact.class);
    }
}
