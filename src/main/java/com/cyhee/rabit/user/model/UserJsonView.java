package com.cyhee.rabit.user.model;

/**
 * User ���� {@link com.fasterxml.jackson.annotation#JsonView}�� Ȱ���� ��
 * ����ϴ� view ��ü, �ش� �Ǵ� ���� Ŭ������ instance�� �������� �ʵ��� �� ��.
 * @author chy
 */
public class UserJsonView {
	// ��ü ���� ����
	private UserJsonView() {}
	
	public static class UserPost {}	
	public static class UserGet {}
}