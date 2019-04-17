package Lab2_Project3MV;

import Lab2_Project3MV.Exceptions.ValidatorException;
import Lab2_Project3MV.Repository.XMLFileRepository.StudentXMLRepo;
import Lab2_Project3MV.Service.XMLFileService.StudentXMLService;
import Lab2_Project3MV.Validator.StudentValidator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class StudentTest {
    private StudentXMLService studentXMLService;

    @Before
    public void setUp() {
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo studentXMLRepo = new StudentXMLRepo(studentValidator, "StudentiXML_test.xml");
        studentXMLService = new StudentXMLService(studentXMLRepo);
    }


    @Test
    public void addStudent() {
        assertTrue(true);
    }

    @Test
    public void testNumberIdStudent() {
        String[] params={"asa", "Ana", "932", "asan@gmail.com", "Zsu"};
        try {
            studentXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testBoundariesIdStudent() {
        String[] params={"1000", "Ana", "932", "asan@gmail.com", "Zsu"};
        String[] params1={"9999", "Ana", "932", "asan@gmail.com", "Zsu"};
        String[] params2={"99", "Ana", "932", "asan@gmail.com", "Zsu"};
        String[] params3={"10000", "Ana", "932", "asan@gmail.com", "Zsu"};
        try {
            studentXMLService.add(params);
            studentXMLService.add(params1);
            studentXMLService.add(params2);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
        try {
            studentXMLService.add(params3);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testEmptyIdStudent() {
        String[] params={"", "Ana", "932", "asan@gmail.com", "Zsu"};
        try {
            studentXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testEmptyStudentName() {
        String[] params={"2234", "", "932", "asan@gmail.com", "Zsu"};
        try {
            studentXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testStudentName() {
        String[] params={"2234", "Todoran Ana-Corina", "932", "asan@gmail.com", "Zsu"};
        String[] params1={"2234", "Ankda334>", "932", "asan@gmail.com", "Zsu"};
        try {
            studentXMLService.add(params);
            studentXMLService.add(params1);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testEmptyTeacherName() {
        String[] params={"2234", "Todoran Ana-Corina", "932", "asan@gmail.com", ""};
        try {
            studentXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testTeacherName() {
        String[] params={"2234", "Todoran Ana-Corina", "932", "asan@gmail.com", "Radu Gaceanu"};
        String[] params1={"2234", "Todoran Ana-Corina", "932", "asan@gmail.com", "akldfms3"};
        try {
            studentXMLService.add(params);
            studentXMLService.add(params1);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testEmptyGroup() {
        String[] params={"2234", "Todoran Ana-Corina", "", "taie2234@gmail.com", "Radu Gaceanu"};
        try {
            studentXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testGroup() {
        String[] params={"2234", "Todoran Ana-Corina", "932", "taie2234@gmail.com", "Radu Gaceanu"};
        String[] params1={"2234", "Todoran Ana-Corina", "-1", "taie2234@gmail.com", "Radu Gaceanu"};
        String[] params2={"2234", "Todoran Ana-Corina", "f", "taie2234@gmail.com", "Radu Gaceanu"};
        try {
            studentXMLService.add(params);
            studentXMLService.add(params1);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }

        try {
            studentXMLService.add(params2);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testEmptyEmail() {
        String[] params={"2234", "Todoran Ana-Corina", "932", "", "Radu Gaceanu"};
        try {
            studentXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testEmail() {
        String[] params={"2234", "Todoran Ana-Corina", "932", "yuvican100@gmail.com", "Radu Gaceanu"};
        String[] params1={"2234", "Todoran Ana-Corina", "932", "john10@somedomain.com", "Radu Gaceanu"};
        String[] params2={"2234", "Todoran Ana-Corina", "932", "msDhoni@somedomain.com", "Radu Gaceanu"};
        String[] params3={"2234", "Todoran Ana-Corina", "932", "'ramesh @gmail.com", "Radu Gaceanu"};
        String[] params4={"2234", "Todoran Ana-Corina", "932", "john10@somedomain", "Radu Gaceanu"};
        try {
            studentXMLService.add(params);
            studentXMLService.add(params1);
            studentXMLService.add(params2);
            studentXMLService.add(params3);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }

        try {
            studentXMLService.add(params4);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }
}
