package com.cyhee.rabit.user.model;

/**
 * User ���� {@link com.fasterxml.jackson.annotation#JsonView}�� Ȱ���� ��
 * ����ϴ� view ��ü
 * @author chy
 */
public class UserView {
	// ��ü ���� ����
	private UserView() {}
	
	public static class UserPost {}	
	public static class UserGet {}
}