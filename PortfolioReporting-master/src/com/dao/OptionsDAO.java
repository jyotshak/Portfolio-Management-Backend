package com.dao;

import java.util.List;

import com.displayAttributes.enrichedoptions;
import com.pojo.Options;
import com.pojo.Security;

public interface OptionsDAO {
	public Options getOptions(String SecuritySymbol);
	public Options updateOptions(Options o,String SecuritySymbol);
	public Options deleteOptions(String SecuritySymbol);
	public Options addOptions(Options o,Security s);
	public List<enrichedoptions> getOptions(int customer_id);
}
