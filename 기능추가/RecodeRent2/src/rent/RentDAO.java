package rent;

import java.util.List;

public interface RentDAO {
	
    boolean insertRent(RentVO rent);
    boolean returnRecord(int rentNo);
    List<RentVO> selectRentsByMember(String memberId);
    List<RentVO> selectAllRents();
	boolean returnRent(int rentNo);
	void loadRents();
    
}
