package controller;

import model.ContactDBConnection;
import model.Contact;
import model.List;

import java.time.LocalDate;

public class ContactController {
    public static String generateNextContactId() {
        ContactDBConnection.lastContactId++;
        return "C" + String.format("%04d", ContactDBConnection.lastContactId);
    }

    // -----------------------SAlARY VALIDATING--------------------------
    public static boolean salaryValidating(double salary) {
        return salary > 0;
    }

    // -----------------------PHONE NUMBER VALIDATING-------------------
    public static boolean phoneNumberValidating(String phoneNumber) {
        return phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0';
    }

    // -----------------------BD VALIDATING------------------------------
    public static boolean validateBirthday(String dateOfBirth) {
        LocalDate date = LocalDate.now();
        int thisYear = date.getYear();
        int thisMonth = date.getMonthValue();
        int today = date.getDayOfMonth();

        int year = Integer.parseInt(dateOfBirth.substring(0, 4));
        int month = Integer.parseInt(dateOfBirth.substring(5, 7));
        int day = Integer.parseInt(dateOfBirth.substring(8, 10));

        if (year > thisYear || (year == thisYear && month > thisMonth)
                || (year == thisYear && month == thisMonth && day > today)) {
            return false;
        }

        if (month < 1 || month > 12 || day < 1 || day > getDaysInMonth(year, month)) {
            return false;
        }

        return true;
    }

    // -----------------------MONTH DAYS VALIDATION----------------------
    public static int getDaysInMonth(int year, int month) {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    // -----------------------LEAP YEAR VALIDATION-----------------------
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean addContact(Contact contact) {
        List list = ContactDBConnection.getInstance().getContactList();
        return list.add(contact);
    }

    public static int search(String nameOrPhone) {
        return ContactDBConnection.list.search(nameOrPhone);
    }

    public static String getContactID(int index) {
        return ContactDBConnection.list.getId(index);
    }

    public static String getName(int index) {
        return ContactDBConnection.list.getName(index);
    }

    public static String getPhoneNumber(int index) {
        return ContactDBConnection.list.getPhoneNumber(index);
    }

    public static String getCompanyName(int index) {
        return ContactDBConnection.list.getCompanyName(index);
    }

    public static double getSalary(int index) {
        return ContactDBConnection.list.getSalary(index);
    }

    public static String getBirthday(int index) {
        return ContactDBConnection.list.getBirthday(index);
    }

    public static void setName(int index, String name) {
        ContactDBConnection.list.updateName(index, name);
    }

    public static void setPhoneNumber(int index, String phoneNumber) {
        ContactDBConnection.list.updatePhoneNumber(index, phoneNumber);
    }

    public static void setCompanyName(int index, String companyName) {
        ContactDBConnection.list.updateCompanyName(index, companyName);
    }

    public static void setSalary(int index, double salary) {
        ContactDBConnection.list.updateSalary(index, salary);
    }

    public static void setBirthDay(int index, String birthday) {
        ContactDBConnection.list.updateName(index, birthday);
    }

    public static void remove(int index) {
        ContactDBConnection.list.remove(index);
    }

    public static Contact[] nameSort() {
        return ContactDBConnection.list.nameSort();
    }

    public static Contact[] salarySort() {
        return ContactDBConnection.list.salarySort();
    }

    public static Contact[] birthdaySort() {
        return ContactDBConnection.list.birthdaySort();
    }
}