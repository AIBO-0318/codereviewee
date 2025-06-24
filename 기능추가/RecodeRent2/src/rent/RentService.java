package rent;

import java.util.List;

public interface RentService {
	
    boolean rentRecord(String memberId, int recordNo);       // 대여 요청
    boolean returnRecord(int rentNo);                         // 반납 처리
    List<RentVO> listMyRents(String memberId);                // 회원의 대여 목록 조회
    List<RentVO> listAllRents();                              // 전체 대여 목록 조회 (관리자용)
	boolean returnRecord(String memberId, int rentNo);
    
}
