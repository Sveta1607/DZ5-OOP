import java.util.List;

public class StudyGroupService {
    // Метод для создания учебной группы
    public StudyGroup createStudyGroup(Teacher teacher, List<Student> students) {
        return new StudyGroup(teacher, students);
    }
}