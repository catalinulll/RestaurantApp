package Controller;
import Domain.Gericht;
import Repository.Repository;

public class Gericht_Controller extends Controller<Gericht> {
    public Gericht_Controller(Repository<Gericht> repository) {
        super(repository);
    }
}