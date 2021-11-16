package egov.service;

import java.util.List;

public interface EmpService {
	/*
	 * 화면 출력 empList.do
	 */
	List<?> selectEmpList(EmpVO vo ) throws Exception;
	/*
	 * 저장처리 empWriteSave.do
	 */
	String insertEmp(EmpVO vo) throws Exception;
	/*
	 * total 갯수 출력 하기
	 */
	int selectEmpTotal() throws Exception;
	/*
	 * 상세보기 empModify.do
	 */
	EmpVO selectEmpDetail(int empno) throws Exception;
	/*
	 * 수정처리하기 empModifySave.do
	 */
	int UpdateEmpDetail(EmpVO vo) throws Exception;
	/*
	 *  삭제처리 empDelete.do
	 */
	int deleteEmp(int empno) throws Exception;

	/*
	 *  사원번호 증감처리 (결과값이 정수기 때문에 int)
	 */
	int selectEmpEmpno() throws Exception;
	
	/*
	 *  셀렉트에 db값 나열하기 (값을 여러개받아서나열하기때문에 List) 는 안씀 ㅡㅡ
		List<?> selectDeptList() throws Exception;
	 */
	
	/*
	 * 업무 출력
	 */
	List<?> selectEmpJobList() throws Exception;
	
}
