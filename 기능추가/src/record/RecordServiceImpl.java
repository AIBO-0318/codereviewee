package record;

import java.util.List;

public class RecordServiceImpl implements RecordService {

	private RecordDAO bookDAO;
	
	public RecordServiceImpl(RecordDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	@Override
	public boolean registRecord(RecordVO record) {
		return bookDAO.insertRecord(record);
	}

	@Override
	public List<RecordVO> listRecords() {
		return bookDAO.selectAllRecords();
	}

	@Override
	public RecordVO detailRecordInfo(int recordNo) {
		
		return bookDAO.selectRecord(recordNo);
	}

	@Override
	public boolean updateRecordPrice(int recordNo, int price) {
		RecordVO record = bookDAO.selectRecord(recordNo);
		
		if (record != null) {
			record.setPrice(price);
			bookDAO.updateRecord(record);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean updateRecordInstock(int recordNo, int instock) {
		RecordVO record = bookDAO.selectRecord(recordNo);
		
		if (record != null) {
			record.setInstock(instock);
			bookDAO.updateRecord(record);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean removeRecord(int recordNo) {
		/*
		RecordVO record = bookDAO.selectRecord(recordNo);
		if (record != null) {
			bookDAO.deleteRecord(recordNo);
			return true;
		}
		return false;
		 */
		return bookDAO.deleteRecord(recordNo);		
	}

}
