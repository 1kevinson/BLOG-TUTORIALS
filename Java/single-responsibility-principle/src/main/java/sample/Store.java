package sample;

public class Store {

    private final BillDatabaseRepository databaseRepository;
    private final BillFileRepository fileRepository;

    public Store(BillDatabaseRepository databaseRepository, BillFileRepository fileRepository) {
        this.databaseRepository = databaseRepository;
        this.fileRepository = fileRepository;
    }

    void saveInFile(Bill bill) {
        // Save bill in File
        // Use fileRepository
    }

    void saveInDatabase(Bill bill) {
        // Save bill in Database
        // Use databaseRepository
    }
}
