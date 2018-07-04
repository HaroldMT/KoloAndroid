package fr.cyberix.kolo.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import fr.cyberix.kolo.helpers.SerializationHelper;
import fr.cyberix.kolo.model.entities.CustomerImage;
import fr.cyberix.kolo.model.entities.MobileDevice;
import fr.cyberix.kolo.model.entities.Person;


public final class Contact {
	public Person person;
	public CustomerImage customerImage;
	public MobileDevice mobileDevice;
	public String imageUrl;
	public String name;
	public String number;
	public Bitmap image;
	
	public Contact() {
	}
	
	public Contact(Person p, CustomerImage ci, MobileDevice md) {
		person = p;
		customerImage = ci;
		mobileDevice = md;
		name = getFullName();
		number = getPhoneNumber();
		image = getImageBitmap();
	}
	
	public String getFullName() {
		if (person == null) return "";
		String fullName = new StringBuilder(person.getLastname()).append(' ').append(person
				                                                                             .getFirstname()).toString();
		return fullName;
	}
	
	public String getPhoneNumber() {
		return mobileDevice.getLineNumber();
	}
	
	public Bitmap getImageBitmap() {
		Bitmap imageBitmap = BytesToBitmap(getImageBytes());
		return imageBitmap;
	}
	
	public static Bitmap BytesToBitmap(byte[] imageBytes) {
		try {
			Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
			return bitmap;
		} catch (Exception ex) {
			return null;
		}
	}
	
	public byte[] getImageBytes() {
		byte[] imageBytes = null;
		if (customerImage != null) {
			imageBytes = customerImage.getImageBytes().toBytes();
		} else {
			imageBytes = new byte[1];
		}
		return imageBytes;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + number.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Contact contact = (Contact) o;
		
		if (!name.equals(contact.name)) return false;
		return number.equals(contact.number);
		
	}
	
	@Override
	public String toString() {
		String jsonValue = SerializationHelper.toJson(this, Contact.class);
		return jsonValue;
	}
}
