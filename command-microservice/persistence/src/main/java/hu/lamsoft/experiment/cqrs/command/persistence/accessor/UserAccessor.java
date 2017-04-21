package hu.lamsoft.experiment.cqrs.command.persistence.accessor;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;

import hu.lamsoft.experiment.cqrs.command.persistence.domain.User;

@Accessor
public interface UserAccessor {
	
    @Query("SELECT * FROM ts.user")
    Result<User> findAll();

}
