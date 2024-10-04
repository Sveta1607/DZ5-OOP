import java.util.ArrayList;
import java.util.List;

public class TeacherController {
    private TeacherService teacherService;
    private TeacherView teacherView;
    private StudyGroupService studyGroupService;

    public TeacherController() {
        this.teacherService = new TeacherService();
        this.teacherView = new TeacherView();
        this.studyGroupService = new StudyGroupService();
    }

    // Метод для добавления учителя
    public void addTeacher(String name, String subject) {
        Teacher teacher = new Teacher(teacherService.getAllTeachers().size() + 1, name, subject);
        teacherService.addTeacher(teacher);
    }

    // Метод для редактирования учителя
    public void editTeacher(int index, String newName, String newSubject) {
        teacherService.editTeacher(index, newName, newSubject);
    }

    // Метод для отображения всех учителей
    public void displayAllTeachers() {
        teacherView.displayTeachers(teacherService.getAllTeachers());
    }

    // Метод для отображения информации о конкретном учителе
    public void displayTeacher(int index) {
        Teacher teacher = teacherService.getTeacher(index);
        teacherView.displayTeacher(teacher);
    }

    // Метод для формирования учебной группы
    public StudyGroup createStudyGroup(int teacherId, List<Integer> studentIds, List<Student> allStudents) {
        Teacher teacher = teacherService.getTeacher(teacherId - 1); // получаем учителя по id
        List<Student> selectedStudents = new ArrayList<>();

        // Фильтруем студентов по их ID
        for (Student student : allStudents) {
            if (studentIds.contains(student.getId())) {
                selectedStudents.add(student);
            }
        }

        // Создаем учебную группу с помощью сервиса
        return studyGroupService.createStudyGroup(teacher, selectedStudents);
    }
}