
package com.SpringHibernate.facade;

import java.util.HashMap;

/**
@aurthor indianic
 */

public interface CityFacade {
	public HashMap<Integer,String> getCitiesByState_id(int state_id);
}
