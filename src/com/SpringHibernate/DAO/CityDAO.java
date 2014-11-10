
package com.SpringHibernate.DAO;

import java.util.HashMap;

/**
@aurthor indianic
 */

public interface CityDAO {
	public HashMap<String,Object> getCitiesByState_id(int state_id);
}
