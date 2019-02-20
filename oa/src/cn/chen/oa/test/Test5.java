package cn.chen.oa.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Test5 {
	@Test
	public void testName1() throws Exception {
//		List<Object> configList = new LinkedList<>();
//        HashMap<String, Object> configMap = new HashMap<>();
//        configMap.put("userId", userId);
//        configMap.put("type", type);
//        configMap.put("company_name", company_name);
//        configMap.put("real_name", real_name);
//        configMap.put("phone", phone);
//        configMap.put("shop_type", shop_type);
//        for (Map.Entry<String,Object> entry : configMap.entrySet()) {
//            if(StringUtils.isBlank(entry.getValue().toString())){
//                businessMessage.setMsg("参数" + entry.getKey() + "不能为空");
//                businessMessage.setSuccess(false);
//                return  businessMessage;
//            }
//        }
		
      HashMap<String, Object> configMap = new HashMap<>();
      configMap.put("userId", "");
      configMap.put("type", 1);
      configMap.put("company_name", 1);
      configMap.put("real_name", 1);
      configMap.put("phone", 1);
      configMap.put("shop_type", 1);
      for (Map.Entry<String,Object> entry : configMap.entrySet()) {
          if(entry.getValue().toString() == null || entry.getValue().toString().length() == 0){
              System.out.println("参数" + entry.getKey() + "不能为空");
          }
      }
	}

}
