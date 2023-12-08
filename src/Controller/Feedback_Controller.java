package Controller;
import Domain.Feedback;
import DAO.Repo_DAO;
public class Feedback_Controller extends Controller<Feedback> {
    public Feedback_Controller(Repo_DAO<Feedback> repository) {
        super(repository);
    }

    public void setRepository(Repo_DAO<Feedback> repository) {
        this.repository = repository;
    }
}