package cn.edu.zhku.shopping.admin.store.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.shopping.admin.store.service.AdminStoreService;
import cn.edu.zhku.shopping.pager.PageBean;
import cn.edu.zhku.shopping.store.store.domain.Store;
import cn.edu.zhku.shopping.user.domain.User;
import cn.itcast.servlet.BaseServlet;
/**
 *管理员管理店铺控制层
 * @author Administrator
 *
 */
public class AdminStoreServlet extends BaseServlet {

	private AdminStoreService adminStoreService=new AdminStoreService();
	/**
	 * 截取url，使得分页的除页码外的链接资源相同，保证访问的是同一个资源
	 *    （前缀相同，后缀不同，&pc=?不同）
	 * 1.url 不存在  &pc  使用默认url 
	 * 2.url 存在  &pc  ,截取掉&pc 
	 * @param req
	 * @return
	 */
	private String getUrl(HttpServletRequest req) {
		
		 //1.url 不存在  &pc  使用默认url 
		//shopping/GoodsServlet?method=findByCategory&cid=xxx&pc=3
		String url=req.getRequestURI()+"?"+req.getQueryString();
		int index = url.lastIndexOf("&pc=");
		 //2.url 存在  &pc  ,截取掉&pc 
		if(index!=-1){
			url=url.substring(0, index);
		}
		return url;
	}

	/**
	 * 获取当前页面
	 * 1.当前页为空，默认为1（第一页）
	 * 2.当前页面不为空时，为pc
	 * @param req
	 * @return
	 */
	private int getPc(HttpServletRequest req) {
		//当前页为空，默认为1（第一页）
		int pc=1;
		String param=req.getParameter("pc");
		//当前页面不为空时，为pc
		if(param!=null &&!param.trim().isEmpty()){
			try{
			pc=Integer.parseInt(param);
			}catch(RuntimeException e){}
		}
		return pc;
		}
	/**
	 * 分页查询
	 * 查询所有店铺
	 * 1.得到当前页pc （1）如果有页面传递，使用页面传递值 （2）如果没传，pc=1
	 * 2.得到访问资源url
	 * 3.通过  pc（当前页）和t_store表 , 调用service同名方法进行查询
	 * 4.给PageBean设置url(访问资源),beanlist(当页记录) 转发到/adminjsps/admin/store/list.jsp
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAllStore(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 // 1.得到当前页pc （1）如果有页面传递，使用页面传递值 （2）如果没传，pc=1
		int pc=getPc(req);
		 // 2.得到访问资源url
		String url=getUrl(req);
		 // 3.通过  pc（当前页）和t_Store表 , 调用service同名方法进行查询
		PageBean<Store> pb=adminStoreService.findAllStore(pc);
		 // 4.给PageBean设置url(访问资源),beanlist(当页记录) 转发到/adminjsps/admin/Store/list.jsp
	
		pb.setUrl(url);//此时pb对象参数才完整
		req.setAttribute("pb", pb);
		return "f:/adminjsps/admin/store/list.jsp";
	}
	
	/**
	 * 按店铺名搜索
	 *   sname
	 * 1.获得用户名sname
	 * 2.调用方法进行搜索，得到store
	 * 3.判断store是否为空
	 * 4.设置相应的request(storeSearch)  msg 搜索情况
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String selectStoreByName(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 // 1.获得用户名loginname
		String sname = req.getParameter("sname");
//		String pb = req.getParameter("pb");
		 // 2.调用方法进行搜索，得到user
		Store storeSearch=adminStoreService.selectStoreByName(sname);
		 // 3.判断user是否为空
		//搜索失败
		if(storeSearch==null){
		// 4.设置相应的request
			req.setAttribute("msg", "搜索失败,不存在该店铺:"+sname);
			req.setAttribute("storeSearch", storeSearch);
//			req.setAttribute("pb", pb);//分页page
			return "f:/adminjsps/admin/user/list.jsp";
		}
		else{
			req.setAttribute("msg", "搜索成功,存在用户："+sname);
			req.setAttribute("storeSearch", storeSearch);
//			req.setAttribute("pb", pb);//分页page
			return "f:/adminjsps/admin/store/list.jsp";
		}
	}
}
