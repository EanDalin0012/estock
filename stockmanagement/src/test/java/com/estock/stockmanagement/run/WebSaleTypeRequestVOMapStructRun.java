package com.estock.stockmanagement.run;

import com.estock.stockmanagement.dto.web.WebSaleTypeDTO;
import com.estock.stockmanagement.mapstruct.web.WebSaleTypeRequestVOMapStruct;
//import com.estock.stockmanagement.vo.request.web.WebSaleTypeRequestVO;
import org.apache.log4j.Logger;

public class WebSaleTypeRequestVOMapStructRun {
	static Logger log = Logger.getLogger(WebSaleTypeRequestVOMapStructRun.class.getName());
	
	public static void main(String[] args) {
		
		try {
//			webSaleTypeRequestVO webSaleTypeRequestVO = new WebSaleTypeRequestVO(1,"Test");
//			WebSaleTypeDTO webSaleTypeDTO = WebSaleTypeRequestVOMapStruct.INSTANCE.webSaleTypeDTO( webSaleTypeRequestVO );
//			webSaleTypeDTO.setId(2);
//			webSaleTypeDTO.setUserId(1);
			
//			log.info("Account already register in blacklist {}"+webSaleTypeDTO.toString());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
}
