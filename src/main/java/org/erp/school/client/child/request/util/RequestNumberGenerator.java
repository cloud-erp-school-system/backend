package org.erp.school.client.child.request.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class RequestNumberGenerator implements IdentifierGenerator {
  private static final String PREFIX = "REQ";
  private static final int BOUNDARY = 99999999;

  @Override
  public Serializable generate(
      SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
      throws HibernateException {
    Connection connection = sharedSessionContractImplementor.connection();
    try {
      Statement statement = connection.createStatement();
      Random random = new Random();
      String id;
      do {
        id = PREFIX + random.nextInt(BOUNDARY);
      } while (!unique(statement, id));
      return id;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public boolean supportsJdbcBatchInserts() {
    return false;
  }

  public boolean unique(Statement statement, String id) throws SQLException {
    ResultSet rs =
        statement.executeQuery("SELECT TOP 1 client.id FROM products WHERE client.id =" + id);
    return !rs.next();
  }
}
