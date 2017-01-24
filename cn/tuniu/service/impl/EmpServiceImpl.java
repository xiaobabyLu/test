package cn.tuniu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.tuniu.dao.vo.Emp;
import cn.tuniu.dbc.DatabaseConnection;
import cn.tuniu.factory.DAOfactory;
import cn.tuniu.service.IEmpService;

public class EmpServiceImpl implements IEmpService {
	private DatabaseConnection dbc =  new DatabaseConnection();
	
	@Override
	public boolean insert(Emp vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			if(DAOfactory.getIEmpDAOIstance(this.dbc.getConnection()).findById(vo.getId())==null)
			{
				return DAOfactory.getIEmpDAOIstance(this.dbc.getConnection()).doCreate(vo);
			}
			
		}catch(Exception e){
			throw e;
		}
		finally {
			// TODO: handle finally clause
			this.dbc.close();
		}
		return false;
	}

	@Override
	public boolean update(Emp vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			return DAOfactory.getIEmpDAOIstance(this.dbc.getConnection()).doUpdate(vo);
			
		}catch(Exception e){
			throw e;
		}
		finally {
			// TODO: handle finally clause
			this.dbc.close();
		}
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		try {
		return DAOfactory.getIEmpDAOIstance(this.dbc.getConnection()).doRemoveBatch(ids);
			
		}catch(Exception e){
			throw e;
		}
		finally {
			// TODO: handle finally clause
			this.dbc.close();
		}
	}

	@Override
	public Emp get(int ids) throws Exception {
		// TODO Auto-generated method stub
		try {
		
			return DAOfactory.getIEmpDAOIstance(this.dbc.getConnection()).findById(ids);
		}catch(Exception e){
			throw e;
		}
		finally {
			// TODO: handle finally clause
			this.dbc.close();
		}
		
	}

	@Override
	public List<Emp> list() throws Exception {
		// TODO Auto-generated method stub
		try {
			return DAOfactory.getIEmpDAOIstance(this.dbc.getConnection()).findAll();
			
		}catch(Exception e){
			throw e;
		}
		finally {
			// TODO: handle finally clause
			this.dbc.close();
		}
	
	}

	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map= new HashMap<String, Object>();
			map.put("allEmps", DAOfactory.getIEmpDAOIstance(this.dbc.getConnection()).findAllSplit(currentPage, lineSize, column, keyWord));
			map.put("empCount",DAOfactory.getIEmpDAOIstance(this.dbc.getConnection()).getAllCount(column, keyWord));
			return map;
		
		}catch(Exception e){
			throw e;
		}
		finally {
			// TODO: handle finally clause
			this.dbc.close();
		}
	}

}
