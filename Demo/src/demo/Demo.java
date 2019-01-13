package demo;

class Demo {
	public static void main(String[] args) {
		  System.setProperty("profile","true");
abc();
	}
	public static void abc()
	{
		String sql=
			    "SELECT \n"+	
			    "    filter_option_short_name \n"+
			    "FROM \n"+
			    "    asm_filter_options_vl fo, \n"+
			    "    asm_svs_filter_options svs_fo, \n"+
			    "    asm_filters_vl afvl \n"+
			    "    WHERE \n"+
			    "   fo.filter_option_id = svs_fo.filter_option_id \n"+
			    "    AND fo.filter_id = afvl.filter_id \n"+
			    "    AND afvl.filter_short_name IN ( \n"+
			    "    'ORA_EXM_USABILITY_ENHANCEMENTS_FOR_EXPENSES' ) \n"+
			    "     AND filter_option_short_name = ( \n"+
			    " 'ORA_SINGLE_PAGE_EXPENSE_ENTRY', \n"+
			    "  );";
		System.out.println(System.getProperty("profile"));
	}
	
    
 

}