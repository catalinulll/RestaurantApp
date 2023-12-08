package Controller;
import Domain.Online_Bestellungen;
import DAO.Repo_DAO;

public class Online_Bestellungen_Controller extends Controller<Online_Bestellungen> {
    public Online_Bestellungen_Controller(Repo_DAO<Online_Bestellungen> repository) {
        super(repository);
    }
}