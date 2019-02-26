/**
 * 
 */
package com.jxxy.mlxc.business.service.impl;

import org.springframework.stereotype.Service;

import com.jxxy.mlxc.business.api.dto.BusinessDto;
import com.jxxy.mlxc.business.service.BusinessService;
import com.mlxc.basic.service.impl.BaseServiceImpl;

/**
 * @Project:mlxc-bussiness-service
 * @Class:BusinessServiceImpl.java
 * @author:zhouyangmin
 * @CreateTime:2019年2月21日上午9:45:02
 * @Description:
 * @Version: 1.0.0 
 *
 */
@Service("businessService")
public class BusinessServiceImpl extends BaseServiceImpl<BusinessDto> implements BusinessService{

	@Override
	public void sayHi() {
		System.out.println("hi,im test");
	}

	
}
