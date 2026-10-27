//package com.kiet.student.controller;
//
//public class StudentController {
//}



package com.kiet.student.controller;

import com.kiet.student.model.Student;
import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(101, "Aman", "aman@gmail.com",
                "AIML", 2, 9.2));

        students.add(new Student(102, "Rahul", "rahul@gmail.com",
                "CSE", 2, 8.5));

        students.add(new Student(103, "Priya", "priya@gmail.com",
                "AIML", 2, 9.5));

        students.add(new Student(104, "Neha", "neha@gmail.com",
                "IT", 3, 8.9));

        students.add(new Student(105, "Rohit", "rohit@gmail.com",
                "CSE", 2, 9.0));
    }

    // 1. Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    // 2. Get student by ID
    @GetMapping("/{studentId}")
    public Object getStudentById(@PathVariable int studentId) {
        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                return s;
            }
        }

        return Map.of("message", "Student not found");
    }

    // 3. Add a new student
    @PostMapping
    public Map<String, String> addStudent(@RequestBody Student student) {
        students.add(student);

        return Map.of("message", "Student added successfully");
    }

    // 4. Update student details
    @PutMapping("/{studentId}")
    public Map<String, String> updateStudent(
            @PathVariable int studentId,
            @RequestBody Student updatedStudent) {

        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                s.setName(updatedStudent.getName());
                s.setEmail(updatedStudent.getEmail());
                s.setBranch(updatedStudent.getBranch());
                s.setYear(updatedStudent.getYear());
                s.setCgpa(updatedStudent.getCgpa());

                return Map.of("message", "Student updated successfully");
            }
        }

        return Map.of("message", "Student not found");
    }

    // 5. Delete student
    @DeleteMapping("/{studentId}")
    public Map<String, String> deleteStudent(
            @PathVariable int studentId) {

        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                students.remove(s);
                return Map.of("message", "Student deleted successfully");
            }
        }

        return Map.of("message", "Student not found");
    }

    // 6. Search students by branch and year
    @GetMapping("/search")
    public List<Student> searchStudents(
            @RequestParam String branch,
            @RequestParam int year) {

        List<Student> result = new ArrayList<>();

        for (Student s : students) {
            if (s.getBranch().equalsIgnoreCase(branch)
                    && s.getYear() == year) {
                result.add(s);
            }
        }

        return result;
    }

    // 7. Get students with CGPA greater than or equal to given CGPA
    @GetMapping("/topper")
    public List<Student> getToppers(@RequestParam double cgpa) {
        List<Student> result = new ArrayList<>();

        for (Student s : students) {
            if (s.getCgpa() >= cgpa) {
                result.add(s);
            }
        }

        return result;
    }
}
