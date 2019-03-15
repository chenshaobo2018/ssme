package cn.chen.oa.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author BOBO
 * @version 2018年11月14日 下午10:20:10
 */

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {
	/**
	 * 图片上传
	 */
	@RequestMapping("user/saveImage")
	@ResponseBody
	public String saveImage(String username,String password,MultipartFile avatar){
		try {
			//原文件名
			String filename = avatar.getOriginalFilename();
			
			//文件后缀
			String prefix = filename.substring(filename.indexOf("."));
			
			//新文件名
			String newName=UUID.randomUUID().toString();
			
			//新文件
			File file = File.createTempFile(newName, prefix);
			
			//把图片写入磁盘中，存在本地某个位置
			avatar.transferTo(file);
			
			//利用七牛云将图片存在云端，返回一个云端地址
			
			//删除临时文件，免得占用内存
			file.delete();
			
			System.out.println("----------");
			System.out.println(filename);
			System.out.println(newName+prefix);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "save user success";
	}
}
