package student;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentManagerTest {
    private static StudentManager manager;

    @BeforeAll
    public static void setUp() {
        manager = new StudentManager();
    }

    @Test
    @Order(1)
    public void shouldAddStudentSuccessfully() {
        manager.addStudent("홍길동");
        assertTrue(manager.hasStudent("홍길동"));
    }

    @Test
    @Order(2)
    public void shouldRemoveStudentSuccessfully() {
        manager.addStudent("김철수");
        assertTrue(manager.hasStudent("김철수"));
        manager.removeStudent("김철수");
        assertFalse(manager.hasStudent("김철수"));
    }

    @Test
    @Order(3)
    public void shouldThrowExceptionWhenAddingDuplicateStudent() {
        manager.addStudent("이영희");
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    manager.addStudent("이영희");
                });
        assertTrue(exception.getMessage().contains("이미 존재하는 학생"));
    }

    @Test
    @Order(4)
    public void shouldThrowExceptionWhenRemovingNonExistingStudent() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    manager.removeStudent("박민수");
                });
        assertTrue(exception.getMessage().contains("존재하지 않는 학생"));
    }
}