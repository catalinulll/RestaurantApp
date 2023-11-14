package Controller;
import Domain.Kundenkarte;
import Repository.Repository;

public class Kundenkarte_Controller extends Controller<Kundenkarte> {
    public Kundenkarte_Controller(Repository<Kundenkarte> repository) {
        super(repository);
    }
}