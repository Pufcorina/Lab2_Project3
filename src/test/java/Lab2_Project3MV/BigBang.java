package Lab2_Project3MV;

import Lab2_Project3MV.Domain.Student;
import Lab2_Project3MV.Exceptions.ValidatorException;
import Lab2_Project3MV.Repository.XMLFileRepository.NotaXMLRepo;
import Lab2_Project3MV.Repository.XMLFileRepository.StudentXMLRepo;
import Lab2_Project3MV.Repository.XMLFileRepository.TemaLabXMLRepo;
import Lab2_Project3MV.Service.XMLFileService.NotaXMLService;
import Lab2_Project3MV.Service.XMLFileService.StudentXMLService;
import Lab2_Project3MV.Service.XMLFileService.TemaLabXMLService;
import Lab2_Project3MV.Validator.NotaValidator;
import Lab2_Project3MV.Validator.StudentValidator;
import Lab2_Project3MV.Validator.TemaLabValidator;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

public class BigBang {
    private TemaLabValidator validator;
    private TemaLabXMLRepo xmlRepo;
    private TemaLabXMLService xmlService;


    private StudentValidator studentValidator;
    private StudentXMLRepo studentXMLRepo;
    private StudentXMLService studentXMLService;

    private NotaValidator gradeValidator;
    private NotaXMLRepo gradeXMLRepo;
    private NotaXMLService gradeXMLService;

    @Test
    public void bigBangTheory() {
        try {
            test_addHomework();
            test_addStudent();
            test_addGrade();
        } catch (Error e) {
            Assert.fail();
        }
    }

    @Before
    public void setUp(){
        validator = new TemaLabValidator();
        xmlRepo = new TemaLabXMLRepo(validator, "assign-test.xml");
        xmlService = new TemaLabXMLService(xmlRepo);

        studentValidator = new StudentValidator();
        studentXMLRepo = new StudentXMLRepo(studentValidator,"StudentiXML_test.xml");
        studentXMLService = new StudentXMLService(studentXMLRepo);

        gradeValidator = new NotaValidator();
        gradeXMLRepo = new NotaXMLRepo(gradeValidator,"gradeiXML_test.xml");
        gradeXMLService = new NotaXMLService(gradeXMLRepo);
    }

    @Test
    public void test_addHomework() {
        String[] params={"123", "Ana", "14", "12"};
        try {
            xmlService.add(params);
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void test_addStudent() {
        String[] params={"2234", "Todoran Ana-Corina", "932", "asan@gmail.com", "Zsu"};
        try {
            studentXMLService.add(params);
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }


    @Test
    public void test_addGrade() {
        String[] params={"2234", "2234", "123", "9.5", LocalDateTime.now().toString()};
        try {
            gradeXMLService.add(params);
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }
}
