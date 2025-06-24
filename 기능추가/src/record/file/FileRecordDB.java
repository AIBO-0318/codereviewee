package record.file;

public interface FileRecordDB {
	String DATA_FILE = "./data/recordDB";
	void saveRecords();
	void loadRecords();
}
