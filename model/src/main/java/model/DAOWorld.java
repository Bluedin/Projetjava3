package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class DAOWorld {

	private final Connection connection;

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *            the connection
	 * @throws SQLException
	 *             the SQL exception
	 */
	public DAOWorld(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	protected Connection getConnection() {
		return this.connection;
	}

	/*
	 * Use the stored procedure to get the map of the level
	 * And create the level corresponding
	 */
	public World find(final int id) {

		World world = new World();
		try {
			final String sql = "{call WorldByLevel(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			while (resultSet.next()) {
				for(int i = 1; i <= resultSet.getString(2).length(); i++){
					world.addElement(resultSet.getString(2).substring(i - 1, i), i, resultSet.getInt(1));
				}
			}
			return null;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return world;
	}

}
