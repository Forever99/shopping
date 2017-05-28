package cn.edu.zhku.shopping.admin.store.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.edu.zhku.shopping.cart.domain.CartItem;
import cn.edu.zhku.shopping.category.domain.Category;
import cn.edu.zhku.shopping.goods.domain.Goods;
import cn.edu.zhku.shopping.pager.PageBean;
import cn.edu.zhku.shopping.pager.PageConstants;
import cn.edu.zhku.shopping.store.store.domain.Store;
import cn.edu.zhku.shopping.user.domain.User;
import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 管理员管理店铺持久层
 * @author Administrator
 *
 */
public class AdminStoreDao {

	private QueryRunner qr=new TxQueryRunner();
	
	/*
	 * 把一个Map映射成一个Store
	 */
	private Store toStore(Map<String,Object> map) {
		if(map == null || map.size() == 0) return null;
		Store store = CommonUtils.toBean(map, Store.class);
		Category category = CommonUtils.toBean(map, Category.class);
		User user = CommonUtils.toBean(map, User.class);
		
		store.setCategory(category);
		store.setUser(user);
		return store;
	}
	
	/*
	 * 把多个Map(List<Map>)映射成多个Store(List<Store>)
	 */
	private List<Store> toStoreList(List<Map<String,Object>> mapList) {
		List<Store> storeList = new ArrayList<Store>();
		for(Map<String,Object> map : mapList) {
			Store store = toStore(map);
			storeList.add(store);
		}
		return storeList;
	}
	
	/**
	 * 分页查询方法
	 * 查询所有用户
	 * 1.得到每页记录pc
	 * 2.得到总记录书tr
	 * 3.得到当前页记录beanList
	 * 4.创建相应的PageBean,返回分页查询结果
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Store> findAllStore(int pc) throws SQLException {
		//1.得到每页记录pc
		int ps=PageConstants.USERIMFO_PAGE_SIZE;
		ArrayList<Object> params = new ArrayList<Object>();//参数
		//2.得到总记录书tr
		String sql="select count(*) from t_store";
		Number number = (Number)qr.query(sql, new ScalarHandler());
		int tr = number.intValue();
		
		//3.得到当前页记录beanList
		sql="select * from t_store s,t_category c,t_user u where s.cid=c.cid and s.uid=u.uid limit ?,?";
		params.add((pc-1)*ps);//当前页记录的开始下标
		params.add(ps);//当前页记录数		
		//List<Store> beanList=qr.query(sql, new BeanListHandler<Store>(Store.class),params.toArray());
		List<Store> beanList=toStoreList(qr.query(sql, new MapListHandler(), params.toArray()));
		//4.创建相应的PageBean,返回分页查询结果
		PageBean<Store> pb=new PageBean<Store>();
		
		//当前PageBean中没设置url，url的设置有Servlet完成
		pb.setBeanList(beanList);//设置记录
		pb.setPc(pc);//设置当前页
		pb.setPs(ps);//设置每页记录
		pb.setTr(tr);//设置总记录
		return pb;
	}
	
	/**
	 * 按店铺名搜索
	 * @param loginname
	 * @return
	 * @throws SQLException 
	 */
	public Store selectStoreByName(String sname) throws SQLException {
		String sql="select * from t_store s,t_category c,t_user u where s.cid=c.cid and s.uid=u.uid and sname=?";
		Map<String,Object> map = qr.query(sql, new MapHandler(), sname);
		return toStore(map);
	}
}
