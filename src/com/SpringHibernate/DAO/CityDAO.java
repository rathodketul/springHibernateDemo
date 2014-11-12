
package com.SpringHibernate.DAO;

import java.util.List;

import com.SpringHibernate.model.CityMaster;

/**
@aurthor indianic
 */

public interface CityDAO {
	public List<CityMaster> getCitiesByState_id(int state_id);
}
