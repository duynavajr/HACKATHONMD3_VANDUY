package ra.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student {
    private static int autoStudentId = 1;
    private int studentId;
    private String studentName;
    private Date birthDay;
    private String address;
    private boolean gender;
    private String phone;

    public Student() {
    }


    public Student(int studentId, String studentName, Date birthDay, String address, boolean gender, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }


    public static int getAutoStudentId() {
        return autoStudentId;
    }

    public static void setAutoStudentId(int autoStudentId) {
        Student.autoStudentId = autoStudentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", birthDay=" + birthDay +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                '}';
    }
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên học sinh: ");
        this.studentName = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            String birthDayStr = scanner.nextLine();

            if (isValidDateFormat(birthDayStr)) {
                String[] dateParts = birthDayStr.split("/");
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);

                if (isValidDate(day, month, year)) {
                    this.birthDay = new Date(year - 1900, month - 1, day);
                    validDate = true;
                } else {
                    System.out.println("Ngày sinh không hợp lệ.");
                }
            } else {
                System.out.println("Định dạng ngày sinh không hợp lệ.");
            }
        }

        System.out.print("Nhập địa chỉ: ");
        this.address = scanner.nextLine();

        System.out.print("Nhập giới tính (Nam/Nữ): ");
        String genderStr = scanner.nextLine();
        this.gender = genderStr.equalsIgnoreCase("Nam");

        boolean validPhone = false;
        while (!validPhone) {
            System.out.print("Nhập số điện thoại (10 hoặc 11 số, bắt đầu bằng số 0): ");
            this.phone = scanner.nextLine();
            if (isValidPhone(this.phone)) {
                validPhone = true;
            } else {
                System.out.println("Số điện thoại không hợp lệ.");
            }
        }
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("0[0-9]{9,10}");
    }


    private boolean isValidDateFormat(String dateStr) {
        return dateStr.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d\\d$");
    }

    private boolean isValidDate(int day, int month, int year) {
        if (year < 1900 || year > 2100 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        int[] maxDaysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            return day <= 29;
        } else {
            return day <= maxDaysInMonth[month - 1];
        }
    }
    public void displayData() {
        System.out.println("Mã học sinh: " + studentId);
        System.out.println("Tên học sinh: " + studentName);
        System.out.println("Ngày sinh: " + birthDay);
        System.out.println("Địa chỉ: " + address);
        System.out.println("Giới tính: " + (gender ? "Nam" : "Nữ"));
        System.out.println("Số điện thoại: " + phone);
    }
}
