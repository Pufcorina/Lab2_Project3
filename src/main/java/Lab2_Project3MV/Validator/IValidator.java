package Lab2_Project3MV.Validator;
import Lab2_Project3MV.Exceptions.ValidatorException;
public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}