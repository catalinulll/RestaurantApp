package Controller;
import Domain.Kundenkarte;
import DAO.Repo_DAO;

public class Kundenkarte_Controller extends Controller<Kundenkarte> {
    public Kundenkarte_Controller(Repo_DAO<Kundenkarte> repository) {
        super(repository);
    }
}