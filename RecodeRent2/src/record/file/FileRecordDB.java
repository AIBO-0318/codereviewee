package record.file;

public interface FileRecordDB {
	String DATA_FILE = "./data/bookDB";
	void saveRecords();
	void loadRecords();
}
