package Tests;
import Controller.Controller;
import Domain.Tische;
import Repository.InMemoryRepository;
import Repository.Repository;
import java.util.List;

public class Controller_Tests {
    private Repository<Tische> tischeRepository;
    private Controller<Tische> tischeController;

    public Controller_Tests() {
        tischeRepository = new InMemoryRepository<Tische>();
        tischeController = new Controller<Tische>(tischeRepository);
    }

    public void testCreate() {
        Tische tische = new Tische(4);
        tischeController.create(tische);
        assert tischeRepository.getAll().size() == 1 : "Test 'testCreate' failed";
        System.out.println("Test 'testCreate' passed.");
    }

    public void testRead() {
        Tische tische = new Tische(4);
        tischeController.create(tische);

        Tische retrievedTische = tischeController.read(tische.getTischeNumber());
        assert retrievedTische != null : "Test 'testRead' failed";
        System.out.println("Test 'testRead' passed.");
    }


    public void testUpdate() {
        Tische tische = new Tische(4);
        tischeController.create(tische);

        tische.setAnzahl_der_Personen(10);
        tischeController.update(tische);

        Tische updatedTische = tischeController.read(tische.getTischeNumber());
        assert updatedTische.getAnzahl_der_Personen() == 10 : "Test 'testUpdate' failed";
        System.out.println("Test 'testUpdate' passed.");
    }


    public void testDelete() {
        Tische tische = new Tische(4);
        tischeController.create(tische);

        tischeController.delete(tische.getTischeNumber());

        List<Tische> allTische = tischeController.getAll();
        assert !allTische.contains(tische) : "Test 'testDelete' failed";
        System.out.println("Test 'testDelete' passed.");
    }



    public void testGetAll() {
        Tische tische1 = new Tische(4);
        Tische tische2 = new Tische(6);
        tischeController.create(tische1);
        tischeController.create(tische2);

        List<Tische> allTische = tischeController.getAll();
        assert allTische.size() == 2 : "Test 'testGetAll' failed";
        System.out.println("Test 'testGetAll' passed.");
    }

    public static void main(String[] args) {
        Controller_Tests tests = new Controller_Tests();
        tests.testCreate();
        tests.testRead();
        tests.testUpdate();
        tests.testDelete();
        tests.testGetAll();
    }
}
