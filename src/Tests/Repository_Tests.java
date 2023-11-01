package Tests;
import Repository.InMemoryRepository;
import Domain.Tische;

import java.util.List;

public class Repository_Tests {
    private InMemoryRepository<Tische> repository;

    public Repository_Tests() {
        repository = new InMemoryRepository<Tische>();
    }

    public void testAdd() {
        Tische tische = new Tische(4);
        repository.add(tische);
        assert repository.getAll().size() == 1 : "Test 'testAdd' failed";
        System.out.println("Test 'testAdd' passed");
    }

    public void testUpdate() {
        Tische tische = new Tische(4);
        repository.add(tische);

        tische.setAnzahl_der_Personen(10);
        repository.update(tische);

        Tische updatedTische = repository.getId(tische.getTischeNumber());
        assert updatedTische.getAnzahl_der_Personen() == 10 : "Test 'testUpdate' failed";
        System.out.println("Test 'testUpdate' passed");
    }

    public void testDelete() {
        Tische tische = new Tische(4);
        repository.add(tische);

        repository.delete(tische);

        Tische deletedTische = repository.getId(tische.getTischeNumber());
        assert deletedTische == null : "Test 'testDelete' failed";
        System.out.println("Test 'testDelete' passed");
    }

    public void testGetAll() {
        Tische tische1 = new Tische(4);
        Tische tische2 = new Tische(6);
        repository.add(tische1);
        repository.add(tische2);

        List<Tische> allTische = repository.getAll();
        assert allTische.size() == 2 : "Test 'testGetAll' failed";
        System.out.println("Test 'testGetAll' passed");
    }

    public static void main(String[] args) {
        Repository_Tests tests = new Repository_Tests();
        tests.testAdd();
        tests.testUpdate();
        tests.testDelete();
        tests.testGetAll();
    }
}