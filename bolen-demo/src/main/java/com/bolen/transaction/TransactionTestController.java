package com.bolen.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/transaction")
public class TransactionTestController {

	@Autowired
	ATransactionService ats;

	@Autowired
	BTransactionService bts;

	/**
	 * 研究事务的传播特性
	 * 场景：B异常，A catch住
	 * 结果：抛出特定异常，A,B都回滚
	 */
	@RequestMapping("/propagation")
	public void propagation() {
		ats.insert();
	}

	@RequestMapping("/propagation2")
	public void propagation2() {
		bts.insert();
	}
}
