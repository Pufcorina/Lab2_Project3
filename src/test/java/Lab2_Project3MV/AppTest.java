package Lab2_Project3MV;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

import Lab2_Project3MV.Exceptions.ValidatorException;
import Lab2_Project3MV.Repository.XMLFileRepository.TemaLabXMLRepo;
import Lab2_Project3MV.Service.XMLFileService.TemaLabXMLService;
import Lab2_Project3MV.Validator.TemaLabValidator;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private TemaLabValidator validator;
    private TemaLabXMLRepo xmlRepo;
    private TemaLabXMLService xmlService;

    @Before
    public void setUp(){
        validator = new TemaLabValidator();
        xmlRepo = new TemaLabXMLRepo(validator, "assign-test.xml");
        xmlService = new TemaLabXMLService(xmlRepo);
    }

    @Test
    public void addHomeworkValid() {
        String[] params={"123", "Ana", "932", "12"};
        try {
            xmlService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            TestCase.assertTrue(true);
        }
    }

    @Test
    public void addHomeworkInvalid() {
        String[] params={"123", "Ana", "932", "12"};
        try {
            xmlService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            TestCase.assertFalse(false);
        }
    }

    @Test
    public void addHomeworkInvalidId() {

        String[] params={"123n", "Ana", "932", "12"};
        try {
            xmlService.add(params);
            fail();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            TestCase.assertFalse(false);
        }
    }

    @Test
    public void addHomeworkInvalidName() {
        String[] params={"123", "1234", "932", "12"};
        try {
            xmlService.add(params);
            fail();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            TestCase.assertFalse(false);
        }
    }

    @Test
    public void addHomeworkInvalidGroup() {
        String[] params={"123", "Name", "exampleFail", "12"};
        try {
            xmlService.add(params);
            fail();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            TestCase.assertFalse(false);
        }
    }




}
