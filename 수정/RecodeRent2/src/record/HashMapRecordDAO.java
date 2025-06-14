package record;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapRecordDAO implements RecordDAO {

	protected Map<Integer, RecordVO> bookDB = new HashMap<>();
	protected int bookSeq = 111;
	
	@Override
	public boolean insertRecord(RecordVO record) {
		record.setRecordNo(bookSeq++);
		record.setRegdate(new Date());
		bookDB.put(record.getRecordNo(), record);
		return true;
		
	}

	@Override
	public RecordVO selectRecord(int recordNo) {
		return bookDB.get(recordNo);
	}

	@Override
	public List<RecordVO> selectAllRecords() {
		return new ArrayList<>(bookDB.values());
	}

	@Override
	public boolean updateRecord(RecordVO newRecord) {
		
		//return bookDB.put(newRecord.getRecordNo(), newRecord) != null;
		if (bookDB.put(newRecord.getRecordNo(), newRecord) != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteRecord(int recordNo) {
		return bookDB.remove(recordNo) != null;
	}

}
