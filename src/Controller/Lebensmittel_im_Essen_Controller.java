package Controller;
import Domain.Lebensmittel_im_Essen;
import DAO.Repo_DAO;

public class Lebensmittel_im_Essen_Controller extends Controller<Lebensmittel_im_Essen> {
    public Lebensmittel_im_Essen_Controller(Repo_DAO<Lebensmittel_im_Essen> repository) {
        super(repository);
    }
}