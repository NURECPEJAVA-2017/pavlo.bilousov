package ua.nure.bilousov.db;

import java.util.Collection;

import java.util.Date;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.junit.Test;

import ua.nure.bilousov.User;
  //DZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ
 //Test update
//Test delete 
public class HsqldbUserDaoTest extends DatabaseTestCase {
	private static final String FIRST_NAME = "John";
	private static final String LAST_NAME = "Doe";
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;
	
	
	protected void setUp() throws Exception {
		super.setUp();
		dao = new HsqldbUserDao (connectionFactory);
	}
		

	
	@Test
    public void testCreate() {
	  User user = new User ();
	  User resUser;
	  Date dateOfBirth = new Date();
	  user.setFirstName(FIRST_NAME);
	  user.setLastName(LAST_NAME);
	  user.setBirthday(dateOfBirth);
	  assertNull(user.getId());
	  try {
		resUser = dao.create(user);
		assertNotNull(resUser);
		assertNotNull(resUser.getId());
		assertEquals(LAST_NAME, resUser.getFirstName());
		assertEquals(dateOfBirth, resUser.getBirthday());
		
	} catch (DatabaseException e) {
		fail(e.getMessage());
		e.printStackTrace();
	}
	  assertNotNull(user);
	  assertNotNull (user.getId());
			 }
	
	 public void testFindAll() {
		try {
			Collection<User> collection = dao.findAll();
			assertNotNull(collection);
			assertEquals(2, collection.size());
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		 
	 }
	
	
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connectionFactory = new ConnectionFactoryImpl();
		return new DatabaseConnection(connectionFactory.createConnection());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataset = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("usersDataSet.xml"));
		return dataset;
		
	}

}
