package Controller;
import Domain.Kunden;
import Repository.Repository;

public class Kunden_Controller extends Controller<Kunden> {
    public Kunden_Controller(Repository<Kunden> repository) {
        super(repository);
    }
}