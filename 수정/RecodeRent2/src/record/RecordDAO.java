package record;

import java.util.List;

public interface RecordDAO {
	boolean insertRecord(RecordVO record);
	RecordVO selectRecord(int recordNo);
	List<RecordVO> selectAllRecords();
	boolean updateRecord(RecordVO newRecord);
	boolean deleteRecord(int recordNo);
}
