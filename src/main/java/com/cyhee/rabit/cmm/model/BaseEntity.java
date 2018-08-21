package com.cyhee.rabit.cmm.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

/**
 * �⺻ ID ���� ����� ���� BaseEntity, �ش� Ŭ������ ����Ͽ� ���
 * @author chy 
 */
@MappedSuperclass
@Data
public class BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
}
