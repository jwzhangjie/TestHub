package com.example.kekeplayer.type;

public class SecondclassItem {
	public static String NAME_ALL = "È«²¿";
	public static String SECONDCLASS_ALL = "";
	private String name;
	private String secondclass;

	public static SecondclassItem getAllItemModel() {
		SecondclassItem localSecondclassItem = new SecondclassItem();
		String str1 = NAME_ALL;
		localSecondclassItem.setName(str1);
		String str2 = SECONDCLASS_ALL;
		localSecondclassItem.setSecondclass(str2);
		return localSecondclassItem;
	}

	public String getName() {
		return this.name;
	}

	public String getSecondclass() {
		return this.secondclass;
	}

	public void setName(String paramString) {
		this.name = paramString;
	}

	public void setSecondclass(String paramString) {
		this.secondclass = paramString;
	}
}