package com.ncalderini.geocell;

import java.util.List;

import com.ncalderini.geocell.model.GeocellQuery;

public interface GeocellQueryEngine {

	<T> List<T> query(GeocellQuery baseQuery, String orderBy, List<String> curGeocellsUnique, Class<T> entityClass);

}