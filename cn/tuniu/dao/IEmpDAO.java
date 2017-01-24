package cn.tuniu.dao;

import java.util.List;
import java.util.Set;

import cn.tuniu.dao.vo.Emp;
/**
 * 定义emp的表开发规范
 * @author luyufeng2
 *
 */
public interface IEmpDAO {
	/**
	 * 实时数据的增加操作
	 * @param vo 包含要增加数据的vo对象
	 * @return 数据保存成功返回true否则返回false
	 * @throws exception sql执行异常
	 */
	public boolean doCreate(Emp vo) throws Exception;
	/**
	 * 实时数据修改，本次操作是根据id进行数据修改
	 * @param vo 包含要增加数据的vo对象
	 * @return 数据保存成功返回true否则返回false
	 * @throws exception
	 */
	public boolean doUpdate(Emp vo) throws Exception;
	/**
	 * 实时数据修改，本次操作是根据id进行数据删除
	 * @param vo 包含要增加数据的vo对象
	 * @return 数据保存成功返回true否则返回false
	 * @throws exception
	 */
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception;
	/**
	 * 查询员工id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Emp findById(Integer id) throws Exception;
	/**
	 * 指定数据的全部记录，并且集合形式返回
	 * @return
	 * @throws Exception
	 */
	public List<Emp> findAll() throws Exception;
	/**
	 * 分页数据模糊查询
	 * @param currentPage当前所在页
	 * @param lineSize每页行数
	 * @param column进行模糊查询的数据列
	 * @param keyWord模糊查询的关键词
	 * @return 查询的结果以集合的形式返回
	 * @throws Exception
	 */
	public List<Emp> findAllSplit(Integer currentPage,Integer lineSize,String column,String keyWord) throws Exception;

	/**
	 * 进行模糊数据量的统计，如果表中没有统计
	 * @param column
	 * @param keyWord
	 * @return 返回表中的数据量，否则返回0
	 * @throws Exception
	 */
	public Integer getAllCount(String column,String keyWord) throws Exception;
}
