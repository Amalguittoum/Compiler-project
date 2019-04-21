
public class SymbolTable extends Object {
	String type;
	String value;
	public SymbolTable(String itype,String ivalue)
	{
		type=itype;
		value=ivalue;
		
	}
	public SymbolTable(String itype,int ivalue)
	{
		type=itype;
		value=String.valueOf(ivalue);
		
	}


}
