package model;

public class List {
    private Node start;

    // ----ADD CONTACT-------
    public boolean add(Contact contact) {
        Node n1 = new Node(contact);
        if (start == null) {
            start = n1;
        } else {
            Node temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n1;
        }
        return true;
    }

    // ----ADD CONTACT TO A INDEX-------
    public void add(int index, Contact contact) {
        Node n1 = new Node(contact);
        if (index >= 0 && index <= size()) {
            if (index == 0) {
                n1.next = start;
                start = n1;
            } else {
                int count = 0;
                Node temp = start;
                while (count < index - 1) {
                    temp = temp.next;
                    count++;
                }
                n1.next = temp.next;
                temp.next = n1;
            }
        }
    }

    // -----SIZE OF OBJECTS
    public int size() {
        Node temp = start;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    // ----SEARCH BY NAME OR PHONE--
    public int search(String nameOrPhone) {
        Node temp = start;
        int index = 0;
        while (temp != null) {
            if (temp.contact.getName().equalsIgnoreCase(nameOrPhone)
                    || temp.contact.getPhoneNumber().equals(nameOrPhone)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    // -----GET ID---
    public String getId(int index) {
        Node temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.contact.getId();
    }

    // -----GET NAME--
    public String getName(int index) {
        Node temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.contact.getName();
    }

    // ----GET PHONE NUMBER--
    public String getPhoneNumber(int index) {
        Node temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.contact.getPhoneNumber();
    }

    // ----GET COMPANY NAME--
    public String getCompanyName(int index) {
        Node temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.contact.getCompanyName();
    }

    // ------GET SALARY--
    public double getSalary(int index) {
        Node temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.contact.getSalary();
    }

    // -----GET BIRTHDAY--
    public String getBirthday(int index) {
        Node temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.contact.getBirthday();
    }

    // -----UPDATE NAME
    public void updateName(int index, String newName) {
        Node temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.contact.setName(newName);
    }

    // -----UPDATE PHONENUMBER
    public void updatePhoneNumber(int index, String newPhoneNumber) {
        Node temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.contact.setPhoneNumber(newPhoneNumber);
    }

    // -----UPDATE COMPANYNAME--
    public void updateCompanyName(int index, String newCompanyName) {
        Node temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.contact.setCompanyName(newCompanyName);
    }

    // -----UPDATE SALARY--
    public void updateSalary(int index, double newSalary) {
        Node temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.contact.setSalary(newSalary);
    }

    // -----DELETE CONTACT BY INDEX
    public void remove(int index) {
        if (index >= 0 && index < size()) {
            if (index == 0) {
                start = start.next;
            } else {
                int count = 0;
                Node temp = start;
                while (count < index - 1) {
                    temp = temp.next;
                    count++;
                }
                temp.next = temp.next.next;
            }
        }
    }

    // -----SORTING BY NAME
    public Contact[] nameSort() {
        Contact[] contactsArray = new Contact[size()];

        Node temp = start;
        for (int i = 0; i < size(); i++) {
            contactsArray[i] = temp.contact;
            temp = temp.next;
        }

        for (int i = 0; i < size() - 1; i++) {
            for (int j = 0; j < size() - 1 - i; j++) {
                if (contactsArray[j].getName().compareToIgnoreCase(contactsArray[j + 1].getName()) > 0) {
                    Contact tempContact = contactsArray[j];
                    contactsArray[j] = contactsArray[j + 1];
                    contactsArray[j + 1] = tempContact;
                }
            }
        }
        return contactsArray;
    }

    // -----SORTING BY SALRAY
    public Contact[] salarySort() {
        Contact[] contactsArray = new Contact[size()];

        Node temp = start;
        for (int i = 0; i < size(); i++) {
            contactsArray[i] = temp.contact;
            temp = temp.next;
        }
        for (int i = 0; i < size() - 1; i++) {
            for (int j = 0; j < size() - 1 - i; j++) {
                if (contactsArray[j].getSalary() > contactsArray[j + 1].getSalary()) {
                    Contact tempContact = contactsArray[j];
                    contactsArray[j] = contactsArray[j + 1];
                    contactsArray[j + 1] = tempContact;
                }
            }
        }
        return contactsArray;
    }

    // -----SORTING BY BIRTHDAY
    public Contact[] birthdaySort() {
        Contact[] contactsArray = new Contact[size()];

        Node temp = start;
        for (int i = 0; i < size(); i++) {
            contactsArray[i] = temp.contact;
            temp = temp.next;
        }

        for (int i = 0; i < size() - 1; i++) {
            for (int j = 0; j < size() - 1 - i; j++) {
                if (contactsArray[j].getBirthday().compareTo(contactsArray[j + 1].getBirthday()) > 0) {
                    Contact tempContact = contactsArray[j];
                    contactsArray[j] = contactsArray[j + 1];
                    contactsArray[j + 1] = tempContact;
                }
            }
        }
        return contactsArray;
    }

    class Node {
        private Contact contact;
        private Node next;

        Node(Contact contact) {
            this.contact = contact;
        }
    }
}