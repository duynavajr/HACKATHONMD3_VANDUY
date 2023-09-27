package ra.run;

import ra.model.Student;
import ra.model.Subject;
import ra.service.StudentService;
import ra.service.SubjectService;


import java.util.Scanner;

public class SchoolManagement {
    private static StudentService studentService = new StudentService();
    private static Scanner scanner = new Scanner(System.in);
   static int choice = scanner.nextInt();// Đọc ký tự Enter

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("************************STUDENT-MANAGEMENT*************************");

            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Quản lý môn học");
            System.out.println("3. Quản lí điểm thi");
            System.out.println("4. Thoát");


            switch (choice) {
                case 1:
                    manageStudents();
                    break;
                case 2:
                    manageStudents();
                    break;
                case 3:
                    // Implement quản lí điểm thi

                    break;
                case 4:
                    exit = true;
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
                    break;
            }
        }
    }

    private static void manageStudents() {
        boolean backToMainMenu = false;
        Scanner scanner1 = new Scanner(System.in);
        scanner1.nextLine();
        while (!backToMainMenu) {
            System.out.println("****************** Quản lý học sinh ******************");
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Sửa thông tin học sinh");
            System.out.println("3. Xóa học sinh");
            System.out.println("4. Tìm kiếm học sinh");
            System.out.println("5. Hiển thị danh sách học sinh");
            System.out.println("6. Quay lại menu chính");

            int choice=Integer.parseInt(scanner1.nextLine());

            switch (choice) {
                case 1:
                    studentService.addStudent(new Student());
                    break;
                case 2:
                    studentService.updateStudent();
                    break;
                case 3:
                    studentService.deleteStudent();
                    break;
                case 4:
                    studentService.searchStudents();
                    break;
                case 5:
                    studentService.getAllStudents();
                    break;
                case 6:
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
                    break;
            }
        }
    }


    public static void subjectMenu(Scanner scanner, SubjectService subjectService) {
        while (true) {
            System.out.println("**********************SUBJECT-MANAGEMENT*************************");
            System.out.println("1. Thêm mới môn học");
            System.out.println("2. Hiển thị danh sách tất cả môn học đã lưu trữ");
            System.out.println("3. Thay đổi thông tin môn học theo mã id");
            System.out.println("4. Xóa môn học theo mã id (kiểm tra điểm thi)");
            System.out.println("5. Thoát");
            System.out.print("Chọn 1, 2, 3, 4 hoặc 5: ");



            switch (choice) {
                case 1:

                    subjectService.addSubject();
                    break;
                case 2:

                    subjectService.displayAllSubjects();
                    break;
                case 3:

                    subjectService.editSubject(scanner.nextLine());
                    break;
                case 4:

                    subjectService.deleteSubject(scanner.nextLine());
                    break;
                case 5:
                    return; // Quay lại menu trước đó
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
