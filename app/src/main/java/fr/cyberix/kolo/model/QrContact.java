package fr.cyberix.kolo.model;

import fr.cyberix.kolo.helpers.ConfigHelper;

public class QrContact {
    int idCustomer;
    String telephone;
    String lastName;
    String firstName;
    String middleName;

    public QrContact() {
        idCustomer = ConfigHelper.getAccountInfo().getCustomer().getIdCustomer();
        telephone = ConfigHelper.getAccountInfo().getMobileDevice().getLineNumber();
        lastName = ConfigHelper.getAccountInfo().getCustomer().getPerson().getLastname();
        firstName = ConfigHelper.getAccountInfo().getCustomer().getPerson().getFirstname();
        middleName = ConfigHelper.getAccountInfo().getCustomer().getPerson().getMiddlename();
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getLineNumber() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();
        if (lastName != null) sb.append(lastName + ' ');
	    if (middleName != null) sb.append(middleName + ' ');
	    if (firstName != null) sb.append(firstName + ' ');
        String fName = sb.toString();
        String fullName = fName.trim();
//        String fullName = (lastName + ' ' + middleName + ' ' + firstName).replace("  ", " ");
        return fullName;
    }
}
