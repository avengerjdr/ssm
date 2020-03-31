package com.woniuxy.domain;

import java.util.List;

public class Page<T> {

	private int p;				// 当前页数
	private int rowCount;		// 总行数
	private int maxPage;		// 总页数
	private int prev;			// 上一页
	private int next;			// 下一页
	private int startLine;		// 起始行
	private int size;			// 每页显示行数
	private int startPage;		// 起始页
	private int endPage;		// 结束页
	private List<T> list;		// 当前页要显示的数据!
	
	// 构造器中，传入以下3个参数，就可以退出另外6个参数！ 
	public Page(int pg, int rc, int sz) {
		p = pg;
		rowCount = rc;
		size = sz;
		
		// 首当其冲，写计算总页数
		maxPage = (int) Math.ceil(rowCount * 1.0 / size);
	
		// 计算出总页数之后，我们要立即把当前页数限定在有效范围之内： 1~maxPage
		if(p > maxPage) p = maxPage;
		if(p < 1) p = 1;
		
		// 流程走到这里，当前页一定是在有效范围之内的,我们就使用这个已经在有效范围内的当前页，再取计算：上一页、下一页、起始行
		prev = p - 1;
		next = p + 1;
		
		/*
		 SELECT * FROM dept LIMIT 0,5
		 SELECT * FROM dept LIMIT 5,5
		 SELECT * FROM dept LIMIT 10,5
		 SELECT * FROM dept LIMIT 15,5
		 SELECT * FROM dept LIMIT (p-1)*5, 5
		*/
		startLine = (p - 1) * size;
		
		if(maxPage < 10) {
			startPage = 1;
			endPage = maxPage;
		} else {
			
			startPage = p - 5;
			endPage = p + 4;
			if(startPage < 1) {
				startPage = 1;
				endPage = 10;
			} 
			if(endPage > maxPage) {
				startPage = maxPage - 9;
				endPage = maxPage;
			}
		}
		
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
 	}
	public int getStartLine() {
		return startLine;
	}
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	
	
}
