package Lab2_Project3MV.Service.TxtFileService;
import Lab2_Project3MV.Domain.*;
import Lab2_Project3MV.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer,Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
