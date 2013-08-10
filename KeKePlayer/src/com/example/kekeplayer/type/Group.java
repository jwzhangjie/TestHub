package com.example.kekeplayer.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Group<T> extends ArrayList<T> implements Serializable{

	private static final long serialVersionUID = 8939312674118931583L;
	private String mType;

	  public Group()
	  {
	  }

	  public Group(Collection<T> paramCollection)
	  {
	    super(paramCollection);
	  }

	  public String getType()
	  {
	    return this.mType;
	  }

	  public void setType(String paramString)
	  {
	    this.mType = paramString;
	  }
	}
