package com.cyhee.rabit.cmm.model;

import com.cyhee.rabit.comment.model.Comment;
import com.cyhee.rabit.goal.model.Goal;
import com.cyhee.rabit.goallog.model.GoalLog;
import com.cyhee.rabit.user.model.User;

/**
 * �ش� ������Ʈ���� �����Ǿ� ���Ǵ� ��� entity ��ü�� ���� type
 * @author chy
 *
 */
public enum ContentType {
	USER(User.class), GOAL(Goal.class), GOALLOG(GoalLog.class), COMMENT(Comment.class);
	
	private Class<?> clazz;
	
	ContentType(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public Class<?> getClazz() {
		return this.clazz;
	}

}
