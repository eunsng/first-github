package egov.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egov.service.NBoardService;
import egov.service.NBoardVO;

@Controller
public class NboardController {
	
	@Resource(name ="nboardService")
	NBoardService nboardSerivce;

	
	@RequestMapping("/admin_nboardList.do")
	public String admin_selectNBoardList (NBoardVO vo ,Model model) throws Exception {
		
		int page_no = vo.getPage_no();  //출력하려는 페이지

		//데이터 출력 범위 설정 (시작 번호 )
		int s_no = (page_no - 1)*10 + 1;
		int e_no = s_no + (10 - 1);
		
		vo.setS_no(s_no);
		vo.setE_no(e_no);
		
		
		vo.setUnq3("0");
		
		List<?> list = nboardSerivce.selectNBoardList(vo);  //List 출력
		int total = nboardSerivce.selectNBoardTotal(vo);	//전체 검색 개수 출력
		
		
		//총 페이지수
		int total_page = (int)Math.ceil( (double)total/10 );
		
		//행번호
		int rownum = total - (page_no-1)*10;
		

		//list 안에 들어가있는 udate 의 값을 HashMap 으로 변경하기
		List<Map> list1 = new ArrayList<Map>();
		Map map1 = new HashMap();
		String udate = "";
		
		for( int i = 0; i<list.size(); i++) {
			map1 = (Map) (list.get(i)); // 리스트 데이터중 한 줄을 가져옴
			udate = map1.get("udate") + ""; //그 한줄중에 udate = ~~~ 하나를 가져옴
			udate = udate.substring(0,10).replace("-","/");   //udate ="2021/11/11" 로 바꿔줌
			map1.put("udate",udate);
			list1.add(map1);
		}
		
		
		
		model.addAttribute("s_field",vo.getS_field());
		model.addAttribute("s_text",vo.getS_text());
		
		model.addAttribute("list",list);
		model.addAttribute("total",total);
		model.addAttribute("total_page",total_page);
		model.addAttribute("rownum",rownum);
		

		
		
		
		return "admin/nboardList";
		
		
	}
	@RequestMapping("/admin_nboardWrite.do")
	public String admin_nboardWrite() {
		
		return "admin/nboardWrite";
	}
	
	
	@RequestMapping("/admin_nboardWriteSave.do")
	//return 데이터를 주소형식이 아닌 문자로 보내려면 어노테이션이 필요함
	@ResponseBody	
	public String admin_insertNBoard(NBoardVO vo) throws Exception{
		
		String result = nboardSerivce.insertNBoard(vo);
		String message = "ok";
		
		if(result != null) {
			message = "error";
		}
		
		return message;
	}
	
	@RequestMapping("/admin_nboardModify.do")
	public String admin_nBoardModify( NBoardVO vo, Model model ) 
										throws Exception{
		
		int unq = Integer.parseInt(vo.getUnq());

		NBoardVO vo1 = nboardSerivce.selectNBoardModify(unq);
		nboardSerivce.updateNBoardHits(vo);

		String unq1 = "";
		String unq2 = "";
		String data = "";
		String[] array;
		int len = 0;
		
		Map<String,String> map = new HashMap<String,String>();
		
		vo.setUnq1(unq+"");
		vo.setUnq2(null);
		List<?> list = nboardSerivce.selectNBoardList(vo);
		len = list.size();
		if(len > 0) {
			data = (Map)list.get(len-1) + "";
			array = data.split(", ");
			unq1 = array[1].split("=")[1];
		}
		
		vo.setUnq1(null);
		vo.setUnq2(unq+"");
		list = nboardSerivce.selectNBoardList(vo);
		len = list.size();
		if(len > 0) {
			data = (Map)list.get(0) + "";
			array = data.split(", ");
			unq2 = array[1].split("=")[1];
		}
		
		String unq_before = unq2;
		String unq_next = unq1;
		
		vo1.setUnq(""+unq);
		model.addAttribute("vo",vo1);				//상세보기 데이터
		model.addAttribute("before",unq_before);	//이전 unq	
		model.addAttribute("next",unq_next);		//다음 unq
		model.addAttribute("s_field",vo.getS_field());		//다음 unq
		model.addAttribute("s_text",vo.getS_text());		//다음 unq
		
		return "admin/nboardModify";
	}
	
	
	@RequestMapping("/admin_nboardModifySave.do")
	@ResponseBody
	public String admin_insertNBoardModify(NBoardVO vo) throws Exception{

		int result2 = nboardSerivce.updateNBoardModifySave(vo);
		String message = "ok";
		
		if(result2 == 0) {
			message = "error12312";
		}
		
		return message;
	}
	
	@RequestMapping("/admin_nboardDelete.do")
	@ResponseBody
	public String admin_nboardDelete(int unq) throws Exception{
		
		int result_del = nboardSerivce.deleteNBoardList(unq);
		String message = "ok";
		
		if(result_del == 0) {
			message = "error";
		}
		
		return message;
	}
	
	@RequestMapping("/admin_nboardAllDelete.do")
	@ResponseBody
	public String admin_nboardAllDelete(String values) throws Exception{
		
		
		//11, 8 ,5 
		//delete from nboard where unq = '11' or unq ='8' or unq ='5';
		//delete from nboard where unq in ('11','8','5');
		values = values.substring(0,values.length()-1);
		int result = nboardSerivce.deleteAllNBoardList(values);
		System.out.println("result: "+ result);
		
		String message = "ok";
		if(result == 0) message = "fail";
		return message;
		
	}
	
	
	
}
