package cn.edu.zhku.shopping.goods.service;

import java.sql.SQLException;

import cn.edu.zhku.shopping.goods.dao.GoodsDao;
import cn.edu.zhku.shopping.goods.domain.goods.Goods;
import cn.edu.zhku.shopping.pager.PageBean;

/**
 * 商品模块业务层
 * @author Administrator
 *
 */
public class GoodsService {

	private GoodsDao goodsDao=new GoodsDao();

	/**
	 * 主页菜单显示，按分类查
	 * @param cid
	 * @param pc
	 * @return
	 */
	public PageBean<Goods> findByCategory(String cid, int pc) {

		try {
			return GoodsDao.findByCategory(cid,pc);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
