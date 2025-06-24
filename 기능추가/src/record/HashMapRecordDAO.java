package record;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapRecordDAO implements RecordDAO {

	protected Map<Integer, RecordVO> recordDB = new HashMap<>();
	protected int recordSeq = 111;
	
	@Override
	public boolean insertRecord(RecordVO record) {
		record.setRecordNo(recordSeq++);
		record.setRegdate(new Date());
		recordDB.put(record.getRecordNo(), record);
		return true;
		
	}

	@Override
	public RecordVO selectRecord(int recordNo) {
		return recordDB.get(recordNo);
	}

	@Override
	public List<RecordVO> selectAllRecords() {
		return new ArrayList<>(recordDB.values());
	}

	@Override
	public boolean updateRecord(RecordVO newRecord) {
		
		//return bookDB.put(newRecord.getRecordNo(), newRecord) != null;
		if (recordDB.put(newRecord.getRecordNo(), newRecord) != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteRecord(int recordNo) {
		return recordDB.remove(recordNo) != null;
	}

}
