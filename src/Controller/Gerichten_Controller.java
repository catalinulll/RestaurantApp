package Controller;
import Domain.Gerichten;
import Repository.Repository;

public class Gerichten_Controller extends Controller<Gerichten> {
    public Gerichten_Controller(Repository<Gerichten> repository) {
        super(repository);
    }
}