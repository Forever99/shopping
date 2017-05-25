package cn.edu.zhku.shopping.admin.store.web.servlet;

import javax.servlet.http.HttpServlet;

import cn.edu.zhku.shopping.admin.store.service.AdminStoreService;
/**
 *管理员管理店铺控制层
 * @author Administrator
 *
 */
public class AdminStoreServlet extends HttpServlet {

	private AdminStoreService adminStoreService=new AdminStoreService();
}
