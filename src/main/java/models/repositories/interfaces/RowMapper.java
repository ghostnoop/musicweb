/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T mapRow(ResultSet row) throws SQLException;
}
