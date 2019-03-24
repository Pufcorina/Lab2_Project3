package Lab2_Project3MV.Validator;
import Lab2_Project3MV.Exceptions.ValidatorException;
import Lab2_Project3MV.Domain.Student;

public class StudentValidator implements IValidator<Student> {

    public void validate(Student s) throws ValidatorException {
        String errors="";
        if(s.getId().equals("")){
            throw new ValidatorException("Id invalid, empty\n");
            //errors+="Id invalid\n";
        }

        if(!s.getId().matches("[+-]?[0-9][0-9]*[.]?[0-9][0-9]*")){
            throw new ValidatorException("Id invalid number\n");
            //errors+="Id invalid number\n";
        }
        if(!s.getId().matches("[0-9][0-9]*")){
            throw new ValidatorException("Id invalid natural number\n");
            //errors+="Id invalid natural number\n";
        }
        if(Integer.parseInt(s.getId()) > 9999 || Integer.parseInt(s.getId()) < 1000){
            throw new ValidatorException("Id invalid boundaries\n");
            //errors+="Id invalid natural number\n";
        }
        if(s.getNume().equals("") || s.getNume()==null){
            //throw new ValidatorException("Nume invalid\n");
            errors+="Nume invalid\n";
        }
        if(s.getGrupa()<=0){
            //throw new ValidatorException("Grupa invalida\n");
            errors+="Grupa invalid\n";
        }
        if(s.getEmail().equals("") || s.getEmail()==null){
            //throw new ValidatorException("Email invalid\n");
            errors+="Email invalid\n";
        }
        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }
    }
}