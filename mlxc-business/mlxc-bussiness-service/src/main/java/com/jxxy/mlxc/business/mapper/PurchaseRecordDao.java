/**
 * 
 */
package com.jxxy.mlxc.business.mapper;

import com.jxxy.mlxc.business.api.dto.PurchaseRecordDto;
import com.jxxy.mlxc.business.api.dto.RecordsDto;
import com.jxxy.mlxc.business.api.model.PurchaseRecordDO;
import com.jxxy.mlxc.business.api.query.RecordsQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
	int insertPurchaseRecord(PurchaseRecordDto dto);
	/**
	 * 订单列表
	 * @Param:
	 * @Return:List<RecordsDto>
	 */
	List<RecordsDto> listRecords(RecordsQuery query);
	/**
	 * 展示我的订单
	 * @Param:
	 * @Return:List<RecordsDto>
	 */
	List<RecordsDto> showMyRecords(RecordsQuery query);

    /**
     * 查询用户是否已经下单
     * @param userId
     * @param productId
     * @return
     */
	Integer countRecords(@Param("userId") Long userId, @Param("productId") Long productId);
}
