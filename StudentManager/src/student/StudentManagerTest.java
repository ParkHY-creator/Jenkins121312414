package student;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentManagerTest {
	
	static StudentManager manager;
	
	@BeforeAll
	static void setUp() throws Exception {
		manager = new StudentManager();
	}

	@Test
	@Order(1) //첫 번째로 실행되는 함수
	void testAddStudent() {
		manager.addStudent("이동규");
		assertTrue(manager.hasStudent("이동규"));
	}

	@Test
	@Order(2)
	void testRemoveStudent() {
		manager.removeStudent("이동규");
		assertFalse(manager.hasStudent("이동규"));
	}
	
	@Test
	@Order(3)
	void testAddDuplicateStudent() {
		manager.addStudent("김철수");
		assertThrows(IllegalArgumentException.class, () -> {
            manager.addStudent("김철수");
		});
	}

	@Test
	@Order(4)
	void testRemoveNonExistStudent() {
		assertThrows(IllegalArgumentException.class, () -> {
            manager.removeStudent("이영희");
        });
	}

}
