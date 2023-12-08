package Controller;
import Domain.Gericht_im_Online_Bestellung;
import DAO.Repo_DAO;

public class Gericht_im_Online_Bestellung_Controller extends Controller<Gericht_im_Online_Bestellung> {
    public Gericht_im_Online_Bestellung_Controller(Repo_DAO<Gericht_im_Online_Bestellung> repository) {
        super(repository);
    }
}