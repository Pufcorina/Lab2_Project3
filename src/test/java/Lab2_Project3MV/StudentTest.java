package Lab2_Project3MV;

import Lab2_Project3MV.Exceptions.ValidatorException;
import Lab2_Project3MV.Repository.XMLFileRepository.StudentXMLRepo;
import Lab2_Project3MV.Service.XMLFileService.StudentXMLService;
import Lab2_Project3MV.Validator.StudentValidator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class StudentTest {
    StudentValidator studentValidator;
    StudentXMLRepo studentXMLRepo;
    StudentXMLService studentXMLService;

    @Before
    public void setUp() {
        studentValidator = new StudentValidator();
        studentXMLRepo = new StudentXMLRepo(studentValidator,"StudentiXML_test.xml");
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
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }
}
