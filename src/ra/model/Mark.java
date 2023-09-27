package ra.model;

import java.util.Scanner;

public class Mark {
    private static int nextMarkId = 1;
    private int markId;
    private Student student;
    private Subject subject;
    private double point;

    // Constructors
    public Mark() {
        this.markId = nextMarkId++;
    }

    public Mark(Student student, Subject subject, double point) {
        this.markId = nextMarkId++;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }



    // Getter và Setter
    public int getMarkId() {
        return markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    // Phương thức để nhập dữ liệu
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        // Kiểm tra nếu sinh viên là null và yêu cầu người dùng thêm sinh viên
        if (student == null) {
            System.out.println("Chưa có thông tin sinh viên. Vui lòng thêm thông tin sinh viên trước.");
            return ;
        }

        // Kiểm tra nếu môn học là null và yêu cầu người dùng thêm môn học
        if (subject == null) {
            System.out.println("Chưa có thông tin môn học. Vui lòng thêm thông tin môn học trước.");
            return;
        }

        System.out.println("Nhập điểm cho Sinh viên " + student.getStudentId()
                + " trong Môn học " + subject.getSubjectId() + ": ");
        double newPoint = scanner.nextDouble();

        // Kiểm tra điểm có hợp lệ hay không
        if (newPoint < 0 || newPoint > 10) {
            System.out.println("Điểm không hợp lệ. Điểm phải nằm trong khoảng từ 0 đến 10.");
        } else {
            this.point = newPoint;
            System.out.println("Điểm đã được thêm thành công.");
        }
    }

    // Phương thức để hiển thị thông tin
    public void displayData() {
        if (student == null || subject == null) {
            System.out.println("Thông tin điểm chưa đầy đủ.");
            return;
        }

        System.out.println("Mã điểm: " + markId);
        System.out.println("Tên Sinh viên: " + student.getStudentName());
        System.out.println("Tên Môn học: " + subject.getSubjectName());
        System.out.println("Điểm số: " + point);
    }
}
