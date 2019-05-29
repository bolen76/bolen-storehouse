package bolen.frame.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
// 定义url的根路径，访问时根路径+方法的url
@RequestMapping("/items")
public class ItemsController {

	// 单独将商品类型的方法提出来，将方法返回值填充到request，在页面显示
	@ModelAttribute("itemsType")
	public Map<String, String> getItemsType() throws Exception {

		HashMap<String, String> itemsType22 = new HashMap<String, String>();
		itemsType22.put("001", "数码");
		itemsType22.put("002", "服装");
		itemsType22.put("003", "食品");
		return itemsType22;

	}

	// 商品信息方法
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request) throws Exception {

		System.out.println(request.getParameter("id"));

		// 调用service查询商品列表

		ModelAndView modelAndView = new ModelAndView();

		// 指定逻辑视图名
		modelAndView.setViewName("editItemsList");

		return modelAndView;
	}

	// 方法返回 字符串，字符串就是逻辑视图名，Model作用是将数据填充到request域，在页面展示
	@RequestMapping(value = "/editItems", method = { RequestMethod.GET })
	public String editItems(Model model, Integer id) throws Exception {

		// 将id传到页面
		model.addAttribute("id", id);

		return "editItem_2";

	}

}
