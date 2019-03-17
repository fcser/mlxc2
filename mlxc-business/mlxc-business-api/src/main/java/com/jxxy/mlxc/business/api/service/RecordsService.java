/**
 * 
 */
package com.jxxy.mlxc.business.api.service;

import java.util.List;

import com.jxxy.mlxc.business.api.dto.PurchaseRecordDto;
import com.jxxy.mlxc.business.api.dto.RecordsDto;
import com.jxxy.mlxc.business.api.query.RecordsQuery;

/**
 * @Project:mlxc-business-api
 * @Class:RecordsService.java
 * @author:zhouyangmin
 * @CreateTime:2019年3月17日下午2:12:41
 * @Description:订单服务
 * @Version: 1.0.0 
 *
 */
public interface RecordsService {

	/**
	 * 订单列表
	 * @Param:
	 * @Return:List<RecordsDto>
	 */
	List<RecordsDto> listRecords(RecordsQuery query);
	/**
	 * 抢单服务
	 * @Param:
	 * @Return:void
	 */
	void purchase(PurchaseRecordDto dto);
	/**
	 * 展示我的订单
	 * @Param:
	 * @Return:List<RecordsDto>
	 */
	List<RecordsDto> showMyRecords(RecordsQuery query);
}
