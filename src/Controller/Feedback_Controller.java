package Controller;
import Domain.Feedback;
import Repository.Repository;
public class Feedback_Controller extends Controller<Feedback> {
    public Feedback_Controller(Repository<Feedback> repository) {
        super(repository);
    }

    public void setRepository(Repository<Feedback> repository) {
        this.repository = repository;
    }
}
