    package com.workshop7.workshop7.controller;

    import com.workshop7.workshop7.entity.Student;
    import com.workshop7.workshop7.service.StudentService;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/students")
    public class StudentController {

        private final StudentService studentService;

        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }

        // Fetch all students
        @GetMapping
        public List<Student> getAllStudents() {
            return studentService.getAllStudents();
        }

        // Fetch a student by ID
        @GetMapping("/{id}")
        public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
            return studentService.getStudentById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        // Create a new student
        @PostMapping
        public Student createStudent(@RequestBody Student student) {
            return studentService.saveStudent(student);
        }

        // Update a student by ID
        @PutMapping("/{id}")
        public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
            try {
                return ResponseEntity.ok(studentService.updateStudent(id, updatedStudent));
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        // Delete a student by ID
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
            try {
                studentService.deleteStudent(id);
                return ResponseEntity.noContent().build();
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }
    }
