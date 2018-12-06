package com.eshop.util;

public class systemContext {
    //设计三个ThreadLocal 来记录与线程有关的与分页有关的变量
	public static ThreadLocal<Integer> offSet=new ThreadLocal<Integer>();//偏移量
	public static ThreadLocal<Integer> pageSize=new ThreadLocal<Integer>();//每页记录数
	public static ThreadLocal<Integer> Count=new ThreadLocal<Integer>();//总记录数
	
	public static int getOffSet() {
		return offSet.get();
	}
	public static void setOffSet(Integer _offSet) {
		offSet.set(_offSet);;
	}
	public static void removeoffSet() {
		offSet.remove();
	}
	
	
	public static int getPageSize() {
		return pageSize.get();
	}
	public static void setPageSize(Integer _pageSize) {
		pageSize.set(_pageSize);
	}
	public static void  removePageSize() {
		pageSize.remove();
	}
	
	public static int getCount() {
		return Count.get();
	}
	public static void setCount(Integer _count) {
		Count.set(_count);;
	}
	public static void removeCount() {
		Count.remove();
	}
	
	
	
	
	
}
