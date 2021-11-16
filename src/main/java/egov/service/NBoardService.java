package egov.service;

import java.util.List;

public interface NBoardService {
	
	/*
	 * 공지사항 등록
	 */
	String insertNBoard(NBoardVO vo) throws Exception;
	
	/*
	 * 목록 출력
	 */
	List<?> selectNBoardList(NBoardVO vo) throws Exception;
	
	/*
	 * 토탈갯수 출력
	 */
	int selectNBoardTotal(NBoardVO vo) throws Exception;
	
	/*
	 * 상세보기
	 */
	NBoardVO selectNBoardModify(int unq) throws Exception;
	
	/*
	 * ModifySave   수정처리
	 */
	int updateNBoardModifySave(NBoardVO vo)throws Exception;
	
	/*
	 * nboardList 개별 삭제처리
	 */
	int deleteNBoardList(int unq) throws Exception;
	
	/*
	 * nboardList 일괄 삭제처리
	 */
	int deleteAllNBoardList(String values) throws Exception;
	
	/*
	 * 조회수 증가
	 */
	int updateNBoardHits(NBoardVO vo) throws Exception;
}
