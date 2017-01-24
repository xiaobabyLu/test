package cn.tuniu.factory;

import cn.tuniu.service.IEmpService;
import cn.tuniu.service.impl.EmpServiceImpl;

public class ServiceFactory {
	public static IEmpService getIEmpServiceInstance(){
		return new EmpServiceImpl();
	}
}
