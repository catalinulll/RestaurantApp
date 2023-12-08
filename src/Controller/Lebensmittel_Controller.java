package Controller;
import Domain.Lebensmittel;
import DAO.Repo_DAO;

public class Lebensmittel_Controller extends Controller<Lebensmittel> {
    public Lebensmittel_Controller(Repo_DAO<Lebensmittel> repository) {
        super(repository);
    }
}