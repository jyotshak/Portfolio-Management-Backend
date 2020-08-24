package com.dao;


import java.util.List;

import com.displayAttributes.enrichedFutures;
import com.pojo.Future;
import com.pojo.Security;

public interface FutureDAO {
	public Future getFuture(String SecuritySymbol);
	public Future updateFuture(Future F,String SecuritySymbol);
	public Future deleteFuture(String SecuritySymbol);
	public Future addFuture(Future F,Security s);
	public List<enrichedFutures> getFuture(int customerId);
}
