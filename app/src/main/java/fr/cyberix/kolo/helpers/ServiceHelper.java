package fr.cyberix.kolo.helpers;

import fr.cyberix.kolo.services.KolOPartVice;
import fr.cyberix.kolo.services.KolOSphere;
import fr.cyberix.kolo.services.KolOthenticor;
import fr.cyberix.kolo.services.MobileService;

public final class ServiceHelper {
	private static KolOSphere kolOSphere;
	private static KolOthenticor kolOthenticor;
	private static MobileService mobileService;
	private static KolOPartVice kolOPartVice;
	
	public static KolOSphere getSphereService() {
		if (kolOSphere == null)
			kolOSphere = new KolOSphere(null, KoloConstants.KolOSphere_BaseUrl);
		return kolOSphere;
	}
	
	public static KolOthenticor getOthenticorService() {
		if (kolOthenticor == null)
			kolOthenticor = new KolOthenticor(null, KoloConstants.KolOthenticor_BaseUrl);
		return kolOthenticor;
	}
	
	public static MobileService getMobileService() {
		if (mobileService == null)
			mobileService = new MobileService(null, KoloConstants.KolOMobileService_BaseUrl);
		return mobileService;
	}
	
	public static KolOPartVice getKolOPartVice() {
		if (kolOPartVice == null)
			kolOPartVice = new KolOPartVice(null, KoloConstants.KolOPartVice_BaseUrl);
		return kolOPartVice;
	}
}
