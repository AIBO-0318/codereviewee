package record;

import java.util.List;

public interface RecordService {
	boolean registRecord(RecordVO record);
	List<RecordVO> listRecords();
	RecordVO detailRecordInfo(int recordNo);
	boolean updateRecordPrice(int recordNo, int price);
	boolean updateRecordInstock(int recordNo, int instock);
	boolean removeRecord(int recordNo);
}
