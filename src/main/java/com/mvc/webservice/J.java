package com.mvc.webservice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mvc.entities.ProductDetails;

@RestController
@RequestMapping("/ws/j")
public class J {
	//http://localhost:8888/restfuldemo/getProduct
	//http://localhost:8888/restfuldemo/getProduct?itemcode=23
	@RequestMapping("/getProduct")
    public @ResponseBody ProductDetails getProductMethod1(@RequestParam(value="itemcode", defaultValue="1") String itemcode) {
		ProductDetails p1 = new ProductDetails();
		p1.setS("s1");
		p1.setSk("sk");
          return  p1;
    }
 
	//http://localhost:8888/restfuldemo/getProduct/itemcode=3456
    @RequestMapping("/getProduct/{itemcode}")
    public @ResponseBody ProductDetails getProductMethod2(@PathVariable(value="itemcode")  String itemcode) {
    	ProductDetails p1 = new ProductDetails();
    	Map<String, String> map1 = new HashMap<String, String>();
    	map1.put("a1", "a1");
    	map1.put("a2", "a2");
    	int[] arrs = new int[] {1, 2, 3,4,5};
    	String[] arrString = new String[] {"String1", "String2", "String3"};
    	List<String> lst = new ArrayList<String>();
    	lst.add("list1");
    	lst.add("list2");
		p1.setS("s2 itemcode");
		p1.setSk("sk2 itemcode " + itemcode);
		p1.setArrLst(lst);
		p1.setArrsInt(arrs);
		p1.setArrsString(arrString);
		p1.setMapStr(map1);
          return  p1;
    }
}
