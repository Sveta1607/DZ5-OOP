import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TeacherController controller = new TeacherController();

        // Добавляем учителей
        controller.addTeacher("Иван Иванов", "Математика");
        controller.addTeacher("Мария Петрова", "Русский язык");

        // Создаем список студентов
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(new Student(1, "Анна Смирнова"));
        allStudents.add(new Student(2, "Алексей Кузнецов"));
        allStudents.add(new Student(3, "Екатерина Морозова"));

        // Отображаем всех учителей
        System.out.println("Список учителей:");
        controller.displayAllTeachers();

        // Создаем учебную группу
        List<Integer> studentIds = new ArrayList<>();
        studentIds.add(1);
        studentIds.add(3);

        StudyGroup studyGroup = controller.createStudyGroup(1, studentIds, allStudents);

        // Отображаем информацию о созданной учебной группе
        System.out.println("\nСозданная учебная группа:");
        System.out.println(studyGroup);
    }
}