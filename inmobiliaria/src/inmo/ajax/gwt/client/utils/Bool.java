package inmo.ajax.gwt.client.utils;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Bool implements IsSerializable
{
	private boolean value;
	
	public Bool(){
		value = false;
	}

	public Bool(boolean value) {
		super();
		this.value = value;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}	
}
