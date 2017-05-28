package cn.edu.zhku.shopping.admin.store.service;

import java.sql.SQLException;

import cn.edu.zhku.shopping.admin.store.dao.AdminStoreDao;
import cn.edu.zhku.shopping.pager.PageBean;
import cn.edu.zhku.shopping.store.store.domain.Store;
import cn.edu.zhku.shopping.user.domain.User;

/**
 * 管理员管理店铺业务层
 * @author Administrator
 *
 */
public class AdminStoreService {

	private AdminStoreDao adminStoreDao=new AdminStoreDao();
	/**
	 * 分页查询方法
	 * 查询所有店铺
	 * @return
	 */
	public PageBean<Store> findAllStore(int pc) {
		try {
			return adminStoreDao.findAllStore(pc);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 按店铺名搜索
	 * @param loginname
	 * @return
	 */
	public Store selectStoreByName(String sname) {
		try {
			return adminStoreDao.selectStoreByName(sname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
