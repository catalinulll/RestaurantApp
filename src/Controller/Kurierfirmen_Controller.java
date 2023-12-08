package Controller;
import Domain.Kurierfirmen;
import DAO.Repo_DAO;

public class Kurierfirmen_Controller extends Controller<Kurierfirmen> {
    public Kurierfirmen_Controller(Repo_DAO<Kurierfirmen> repository) {
        super(repository);
    }
}