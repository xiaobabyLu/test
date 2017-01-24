package cn.tuniu.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.tuniu.dao.vo.Emp;
/**
 * 此类负责打开和关闭数据库操作
 * 此类可以通过DAOfactory取得IEmpDAO的接口对象
 * @author luyufeng2
 *
 */
public interface IEmpService {
	/**
	 * 实现人员的增加，调用IEmpDAO接口的相关方法
	 * 判断id是否存在
	 * 如果不存在进行创建
	 * @param vo包含数据vo的对象
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Emp vo) throws Exception;
	
	/**
	 * 修改相关内容
	 * @param vod
	 * @return
	 * @throws Exception
	 */
	public boolean update(Emp vo) throws Exception;
	/**
	 * 执行批量删除
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Set<Integer> ids) throws Exception;
	/**
	 * 根据人员id查询人员信息
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public Emp get(int ids) throws Exception;
	/**
	 * 查询全部人员信息
	 * @return
	 * @throws Exception
	 */
	public List<Emp> list() throws Exception;
	/**
	 * 实现数据的模糊查询和数据的统计
	 * @param currentPage
	 * @param lineSize
	 * @param column
	 * @param keyWord
	 * @return 返回的数据类型多种，所以使用返回Map，由于类型不统一，所有类型设置成object
	 * @throws Exception
	 */
	public Map<String ,Object> list(int currentPage, int lineSize, String column, String keyWord) throws Exception;
}
