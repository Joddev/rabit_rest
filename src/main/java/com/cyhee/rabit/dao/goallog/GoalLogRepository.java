
package com.cyhee.rabit.dao.goallog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.cyhee.rabit.model.goal.Goal;
import com.cyhee.rabit.model.goallog.GoalLog;
import com.cyhee.rabit.model.user.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface GoalLogRepository extends PagingAndSortingRepository<GoalLog, Long> {
	
	@Query("From GoalLog n Where :author = n.goal.author")
	Page<GoalLog> findAllByAuthor(@Param("author") User author, Pageable pageable);
	
	Page<GoalLog> findAllByGoal(Goal goal, Pageable pageable);
}