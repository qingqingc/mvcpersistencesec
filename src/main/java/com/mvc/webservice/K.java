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
@RequestMapping("/ws/k")
public class K {
	//http://localhost:8888/mvcpersistence/ws/k/gok
	//http://localhost:8888/restfuldemo/getProduct?itemcode=23
	@RequestMapping("/gok")
    public @ResponseBody ProductDetails getProductMethod1(@RequestParam(value="itemcode", defaultValue="1") String itemcode) {
		ProductDetails p1 = new ProductDetails();
		p1.setS("s1");
		p1.setSk("sk");
          return  p1;
    }
 
	//http://localhost:8888/mvcpersistence/ws/k/retrieve/itemcode=2384
    @RequestMapping("/retrieve/{itemcode}")
    public @ResponseBody ProductDetails getProductMethod2(@PathVariable(value="itemcode")  String itemcode) {
    	ProductDetails p1 = new ProductDetails();
    	Map<String, String> map1 = new HashMap<String, String>();
    	map1.put("k1", "k1");
    	map1.put("k2", "k2");
    	int[] arrs = new int[] {1, 2, 3,4,5};
    	String[] arrString = new String[] {"Strinkg1", "Strking2", "Stkring3"};
    	List<String> lst = new ArrayList<String>();
    	lst.add("lkst1");
    	lst.add("lkst2");
		p1.setS("s2k itemcode");
		p1.setSk("skkkkk2 itemcode " + itemcode);
		p1.setArrLst(lst);
		p1.setArrsInt(arrs);
		p1.setArrsString(arrString);
		p1.setMapStr(map1);
          return  p1;
    }
}
