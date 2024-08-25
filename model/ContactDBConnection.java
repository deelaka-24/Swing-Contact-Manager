package model;

public class ContactDBConnection {
    public static List list;
    public static int lastContactId = 0;
    private static ContactDBConnection contactDBConnection;

    private ContactDBConnection() {
        list = new List();
    }

    public static ContactDBConnection getInstance() {
        if (contactDBConnection == null) {
            contactDBConnection = new ContactDBConnection();
        }
        return contactDBConnection;
    }

    public List getContactList() {
        return list;
    }
}