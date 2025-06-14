package record;

import java.util.LinkedList;
import java.util.List;

public class ListRecordDAO implements RecordDAO {

	private List<RecordVO> recordList = new LinkedList<RecordVO>();
	private int bookSeq = 111; // 책번호 1씩 증가
	
	@Override
	public boolean insertRecord(RecordVO record) {
		record.setRecordNo(bookSeq++);
		recordList.add(record);
		return true;
	}

	@Override
	public RecordVO selectRecord(int recordNo) {
		for (RecordVO record : recordList) {
			if (record.getRecordNo() == recordNo)
				return record;
		}
		return null;
	}

	@Override
	public List<RecordVO> selectAllRecords() {
		return recordList;
	}

	@Override
	public boolean updateRecord(RecordVO newRecord) {
		for (int i = 0; i < recordList.size(); i++) {
			if (recordList.get(i).getRecordNo() == newRecord.getRecordNo()) {
				recordList.set(i, newRecord);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteRecord(int recordNo) {

		for (RecordVO record : recordList) {
			if (record.getRecordNo() == recordNo) {
				recordList.remove(record);
				return true;
			}
		}
		return false;
	}

}
