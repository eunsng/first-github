package egov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileController {
	
	@RequestMapping("fileboardWrite.do")
	public String fileboardWrite() {
		
		return "admin/fileWrite";
	}
}
