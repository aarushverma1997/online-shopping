package org.rv.onlineshopping.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.web.multipart.MultipartFile;


public class FileUploadUtility {
	
	
	private static final String ABS_PATH="E:\\new ide\\workspace\\spring\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	
	private static String REAL_PATH="";

	private static final Logger logger = Logger.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request,MultipartFile file,String code)
	{
		
		
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		
		
		if(!new File(ABS_PATH).exists())
		{
			
			
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists())
		{
			
			
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			
			//server upload
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			
			//project upload
			file.transferTo(new File(ABS_PATH+code+".jpg"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
