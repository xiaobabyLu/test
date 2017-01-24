package cn.tuniu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.tuniu.dao.IEmpDAO;
import cn.tuniu.dao.vo.Emp;

/**
 * 数据库操作过程,需要做哪些操作和修改
 * @author luyufeng2
 *
 */
public class EmpDAOimpl implements IEmpDAO{
	private Connection conn;
	private PreparedStatement pst;
	/**
	 * 如果需要进行数据层原子性功能操作实现，必须提供connection的接口对象
	 * 数据库的打开和关闭由业务层处理
	 * @param conn数据库的连接对象
	 */
	public EmpDAOimpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn=conn;
	}
	
	@Override
	public boolean doCreate(Emp vo) throws Exception {
		// TODO Auto-generated method stub
		String sql="INSERT INTO emp(id,name,product) VALUES(?,?,?)";
		this.pst=this.conn.prepareStatement(sql);
		this.pst.setInt(1, vo.getId());
		this.pst.setString(2,vo.getName());
		this.pst.setString(3, vo.getProduct());
		
		return this.pst.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(Emp vo) throws Exception {
		// TODO Auto-generated method stub
		String sql="UPDATE emp SET name=?,product=? WHERE id=?";
		this.pst=this.conn.prepareStatement(sql);
		this.pst.setString(2,vo.getName());
		this.pst.setString(3,vo.getProduct());
		this.pst.setInt(1, vo.getId());
		
		return this.pst.executeUpdate()>0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		if(ids==null||ids.size()==0){
			return false;
		}
		StringBuffer sql =new StringBuffer();
		sql.append("DELETE FROM emp WHERE id IN(");
		Iterator<Integer> iter = ids.iterator();
		while(iter.hasNext()){
			sql.append(iter.next()).append(",");
		}
		sql.delete(sql.length()-1,sql.length()).append(")");
		this.pst=this.conn.prepareStatement(sql.toString());
		
		return this.pst.executeUpdate()==ids.size();
	}

	@Override
	public Emp findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Emp vo =null;
		String sql="SELECT id,name,product FROM emp WHERE id=?";
		this.pst=this.conn.prepareStatement(sql);
		this.pst.setInt(1, id);
		ResultSet rSet=this.pst.executeQuery();
		if(rSet.next()){
			vo = new Emp();
			vo.setId(rSet.getInt(1));
			vo.setName(rSet.getString(2));
			vo.setProduct(rSet.getString(3));
		}
		return vo;
	}

	@Override
	public List<Emp> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Emp> all =new ArrayList<>();
		String sql = "SELECT id,name,product FROM emp";
		this.pst=this.conn.prepareStatement(sql);
		ResultSet rSet=this.pst.executeQuery();
		while(rSet.next()){
			Emp vo = new Emp();
			vo.setId(rSet.getInt(1));
			vo.setName(rSet.getString(2));
			vo.setProduct(rSet.getString(3));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Emp> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws Exception {
		List<Emp> all =new ArrayList<>();
		String sql = "SELECT * FROM"
				+ "(SELECT id,name,product ,ROWNUM rn"
				+ "FROM emp"
				+ "WHERE "+column+" LIKE ? AND ROWNUM<=?) temp"
						+ "WHERE temp.rn>?";
		this.pst=this.conn.prepareStatement(sql);
		this.pst.setString(1,"%" +keyWord+ "%");
		this.pst.setInt(2, currentPage * lineSize);
		this.pst.setInt(3, (currentPage-1)*lineSize);
		ResultSet rSet=this.pst.executeQuery();
		while(rSet.next()){
			Emp vo = new Emp();
			vo.setId(rSet.getInt(1));
			vo.setName(rSet.getString(2));
			vo.setProduct(rSet.getString(3));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		String sql="SELECT COUNT(id) FROM emp WHERE "+column+" LIKE ?";
		this.pst=this.conn.prepareStatement(sql);
		this.pst.setString(1,"%"+keyWord+"%");
		ResultSet rSet=this.pst.executeQuery();
		if(rSet.next()){
			return rSet.getInt(1);
		}
		return null;
	}

}
