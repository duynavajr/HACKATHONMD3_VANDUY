package ra.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subject {
    private static int autoSubjectId = 1;
    private String subjectId;
    private String subjectName;
    private static List<String> subjectNamesList = new ArrayList<>();

    public Subject() {
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public static int getAutoSubjectId() {
        return autoSubjectId;
    }

    public static void setAutoSubjectId(int autoSubjectId) {
        Subject.autoSubjectId = autoSubjectId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public static List<String> getSubjectNamesList() {
        return subjectNamesList;
    }

    public static void setSubjectNamesList(List<String> subjectNamesList) {
        Subject.subjectNamesList = subjectNamesList;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã môn học (MH): ");
        String id = scanner.nextLine();
        while (!isValidSubjectId(id)) {
            System.out.println("Mã môn học không hợp lệ,môn học bắt đầu từ chữ (MH): ");
            id = scanner.nextLine();
        }
        this.subjectId = id;

        System.out.print("Nhập tên môn học: ");
        String name = scanner.nextLine();
        while (name.isEmpty() || isSubjectName(name)) {
            if (name.isEmpty()) {
                System.out.println("Tên môn học không được để trống. Vui lòng nhập lại.");
            } else {
                System.out.println("Tên môn học đã tồn tại. Vui lòng nhập lại.");
            }
            name = scanner.nextLine();
        }
        this.subjectName = name;
    }

    public void displayData() {
        System.out.println("Mã môn học: " + subjectId);
        System.out.println("Tên môn học: " + subjectName);
    }


    private boolean isValidSubjectId(String id) {
        return id.matches("^MH\\d{3}$");
    }
    private boolean isSubjectName(String name) {

        for (String existingName : subjectNamesList) {
            if (existingName.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
