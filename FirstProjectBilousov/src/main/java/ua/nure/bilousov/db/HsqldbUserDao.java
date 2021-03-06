package ua.nure.bilousov.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.concurrent.Callable;

import ua.nure.bilousov.User;

public class HsqldbUserDao implements DAO<User> {

	private static final String INSERT_QUERY = "INSERT INTO users (firstname, lastname, dateOfBirth) VALUES (?, ?, ?)";
	private ConnectionFactory connectionFactory;

	public HsqldbUserDao(ConnectionFactory connectionFactory) {
	    this.connectionFactory = connectionFactory;
	}

	@Override
	public User create(User user) throws DatabaseException {
		try {
			User resultUser = new User(user);
			Connection connection = connectionFactory.createConnection();
			PreparedStatement statement = connection.prepareStatement(
					 INSERT_QUERY);
			statement.setString( 1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setDate(3, new Date (user.getBirthday().getTime()));
			int n = statement.executeUpdate();
			if (n !=1) {
				throw new DatabaseException("Number of the inserted rows:" + n);
			}
				CallableStatement callableStatement = connection.prepareCall("call IDENTITY()"); 
				ResultSet id = callableStatement.executeQuery();
				if (id.next()){
					resultUser.setId(new Long(id.getLong(1)));
					
				}
				id.close();
				callableStatement.close();
				statement.close();
				connection.close();
				return resultUser;
				
				
				
		} catch (SQLException e) {
			throw new DatabaseException(e);

	}
		
	}

	@Override
	public User update(User t) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User t) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User find(Long id) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> findAll() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
