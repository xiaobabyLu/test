package cn.tuniu.factory;

import java.sql.Connection;

import cn.tuniu.dao.IEmpDAO;
import cn.tuniu.dao.impl.EmpDAOimpl;

public class DAOfactory {
	public static IEmpDAO getIEmpDAOIstance(Connection conn){
		return new EmpDAOimpl(conn);
	}

}
