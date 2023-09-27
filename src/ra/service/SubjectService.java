package ra.service;
import ra.model.Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubjectService {
    private List<Subject> subjects;

    public SubjectService() {
        subjects = new ArrayList<>();
    }

    // Thêm mới môn học
    public void addSubject() {
        Subject newSubject = new Subject();
        newSubject.inputData();
        subjects.add(newSubject);
        System.out.println("Đã thêm môn học mới:");
        newSubject.displayData();
    }

    // Hiển thị danh sách tất cả môn học đã lưu trữ
    public void displayAllSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("Danh sách môn học trống.");
        } else {
            System.out.println("Danh sách môn học:");
            for (Subject subject : subjects) {
                subject.displayData();
                System.out.println("--------------------------");
            }
        }
    }

    // Sửa thông tin môn học theo mã môn học
    public void editSubject(String subjectId) {
        for (Subject subject : subjects) {
            if (subject.getSubjectId().equalsIgnoreCase(subjectId)) {
                System.out.println("Nhập thông tin môn học mới:");
                subject.inputData();
                System.out.println("Đã cập nhật thông tin môn học:");
                subject.displayData();
                return;
            }
        }
        System.out.println("Không tìm thấy môn học với mã: " + subjectId);
    }

    // Xóa môn học theo mã môn học (kiểm tra xem môn học có điểm thi hay không)
    public void deleteSubject(String subjectId) {
        for (Subject subject : subjects) {
            if (subject.getSubjectId().equalsIgnoreCase(subjectId)) {
                subjects.remove(subject);
                System.out.println("Đã xóa môn học có mã: " + subjectId);
                return;
            }
        }
        System.out.println("Không tìm thấy môn học với mã: " + subjectId);
    }
}
