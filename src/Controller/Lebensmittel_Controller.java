package Controller;
import Domain.Lebensmittel;
import Repository.Repository;

public class Lebensmittel_Controller extends Controller<Lebensmittel> {
    public Lebensmittel_Controller(Repository<Lebensmittel> repository) {
        super(repository);
    }
}