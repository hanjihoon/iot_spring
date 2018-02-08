package com.iot.spring.vo;

public class ColumnInfoVo {
	private String columnName;
	private String columnDefault;
	private String isNullable;
	private String dataType;
	private String charMaxLength;
	private String columnType;
	private String columnKey;
	private String columnComent;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnDefault() {
		return columnDefault;
	}
	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}
	public String getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getCharMaxLength() {
		return charMaxLength;
	}
	public void setCharMaxLength(String charMaxLength) {
		this.charMaxLength = charMaxLength;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	public String getColumnComent() {
		return columnComent;
	}
	public void setColumnComent(String columnComent) {
		this.columnComent = columnComent;
	}
	@Override
	public String toString() {
		return "ColumnInfoVo [columnName=" + columnName + ", columnDefault=" + columnDefault + ", isNullable="
				+ isNullable + ", dataType=" + dataType + ", charMaxLength=" + charMaxLength + ", columnType="
				+ columnType + ", columnKey=" + columnKey + ", columnComent=" + columnComent + "]";
	}
}
