package egov.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egov.service.NBoardVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("nboardDAO")
public class NBoardDAO extends EgovAbstractDAO{

	public String insertNBoard(NBoardVO vo) {
		return (String) insert("nboardDAO.insertNBoard",vo);
	}

	public List<?> selectNBoardList(NBoardVO vo) {
		return list("nboardDAO.selectNBoardList",vo);
	}

	public int selectNBoardTotal(NBoardVO vo) {
		return (int) select("nboardDAO.selectNBoardTotal",vo);
	}

	public NBoardVO selectNBoardModify(int unq) {
		return  (NBoardVO) select("nboardDAO.selectNBoardModify",unq);
	}

	public int updateNBoardModifySave(NBoardVO vo) {
		return update("nboardDAO.updateNBoardModifySave",vo);
	}

	public int deleteNBoardList(int unq) {
		return delete("nboardDAO.deleteNBoardList",unq);
	}

	public int deleteAllNBoardList(String values) {
		return delete("nboardDAO.deleteAllNBoardList",values);
	}

	public int updateNBoardHits(NBoardVO vo) {
		return update("nboardDAO.updateNBoardHits",vo);
	}


}
