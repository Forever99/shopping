package cn.edu.zhku.shopping.store.category.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.shopping.category.domain.Category;
import cn.edu.zhku.shopping.category.service.CategoryService;
import cn.itcast.servlet.BaseServlet;

public class StoreCategoryServlet extends BaseServlet {
	
	private CategoryService categoryService=new CategoryService();

	/**
	 * 查找所有的店铺类型，并以json格式返回
	 * 1.通过service得到所有分类及其子分类，保存在List中
	 * 2.设置成json格式返回
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxFindParents(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.通过service得到所有分类及其子分类，保存在List中
		List<Category> parents=categoryService.findAll();
		
		
		req.setAttribute("parents", parents);
//		//2.设置成json格式返回
//		String json = toJson(parents);
//		resp.getWriter().print(json);
		
		return "f:/storejsps/mystore.jsp";
	}
	
//	/**
//	 * 多个category对象 写到多个json {} 中
//	 * eg:[{"cid":"fdsafdsa", "cname":"fdsafdas"}, {"cid":"fdsafdsa", "cname":"fdsafdas"}]
//	 * @param categoryList
//	 * @return
//	 */
//	
//	private String toJson(List<Category> categoryList) {
//		StringBuilder sb = new StringBuilder("[");
//		for(int i = 0; i < categoryList.size(); i++) {
//			sb.append(toJson(categoryList.get(i)));//一个category对象
//			if(i < categoryList.size() - 1) {
//				sb.append(",");
//			}
//		}
//		sb.append("]");
//		return sb.toString();
//	}
//	/**
//	 * 一个category对象写到一个json {} 中
//	 * eg:{"cid":"fdsafdsa", "cname":"fdsafdas"}
//	 * @param category
//	 * @return
//	 */
//	
//	private String toJson(Category category) {
//		StringBuilder sb = new StringBuilder("{");
//		sb.append("\"cid\"").append(":").append("\"").append(category.getCid()).append("\"");
//		sb.append(",");
//		sb.append("\"cname\"").append(":").append("\"").append(category.getCname()).append("\"");
//		sb.append("}");
//		return sb.toString();
//	}
}
