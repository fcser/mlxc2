/**
 * 
 */
package com.jxxy.mlxc.business.mapper;

import com.jxxy.mlxc.business.api.model.PurchaseRecordDO;

/**
 * @Project:mlxc-bussiness-service
 * @Class:PurchaseRecordDao.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月27日上午11:19:44
 * @Description:用户购买记录表
 * @Version: 1.0.0 
 *
 */
public interface PurchaseRecordDao {

	/**
	 * 插入购买记录
	 * @Param:
	 * @Return:int
	 */
	int insertPurchaseRecord(PurchaseRecordDO DO);
}
