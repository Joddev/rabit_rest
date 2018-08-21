package com.cyhee.rabit.cmm.web.exception;

import org.springframework.http.HttpStatus;

import com.cyhee.rabit.cmm.web.model.ApiErrorCode;

/**
 * Rest Api���� �߻��ϴ� Exception�� ���� interface
 * �ش� interface�� ������ Exception�� �̿��� ���� ����
 * @author chy
 *
 */
public interface ApiException {
	ApiErrorCode getApiErrorCode();	
	HttpStatus getStatus();
	String getMessage();
}
