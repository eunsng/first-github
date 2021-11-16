package egov.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egov.service.NBoardService;
import egov.service.NBoardVO;


@Service("nboardService")
public class NBoardImpl  implements NBoardService{

	@Resource(name = "nboardDAO")
	NBoardDAO nboardDAO;
	
	@Override
	public String insertNBoard(NBoardVO vo) throws Exception {
		return nboardDAO.insertNBoard(vo);
	}

	@Override
	public List<?> selectNBoardList(NBoardVO vo) throws Exception {
		return nboardDAO.selectNBoardList(vo);
	}

	@Override
	public int selectNBoardTotal(NBoardVO vo) throws Exception {
		return nboardDAO.selectNBoardTotal(vo);
	}

	@Override
	public NBoardVO selectNBoardModify(int unq) throws Exception {
		return nboardDAO.selectNBoardModify(unq);
	}

	@Override
	public int updateNBoardModifySave(NBoardVO vo) throws Exception {
		return nboardDAO.updateNBoardModifySave(vo);
	}

	@Override
	public int deleteNBoardList(int unq) throws Exception {
		return nboardDAO.deleteNBoardList(unq);
	}

	@Override
	public int deleteAllNBoardList(String values) throws Exception {
		return nboardDAO.deleteAllNBoardList(values);
	}

	@Override
	public int updateNBoardHits(NBoardVO vo) throws Exception {
		return nboardDAO.updateNBoardHits(vo);
	}




}
