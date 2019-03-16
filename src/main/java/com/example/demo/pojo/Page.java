package com.example.demo.pojo;

import java.util.List;

public class Page<T extends Object>{
	private List<T> records;
	private int pagesize = 10;//每页显示的记录条数
	private int pagenum;//用户要看的页码即当前页码
	private int totalpage;//总页数
	private int startIndex;//每页开始记录的索引
	private int totalrecords;//总记录条数
	
	//显示的页码
	private int startPage;
	private int endPage;
	
	//查询数据时的Servlet的URL
	private String servletUrl;
	
	/**
	 * 内存分页
	 * @param pagenum
	 * @param totalrecords
	 */
	public Page(int pagenum, List<T> totalrecords)
	{
		this.pagenum = pagenum;
		if(totalrecords!=null)
			this.totalrecords = totalrecords.size();
		else {
			this.totalrecords=0;
		}
		
		//计算每页开始记录的索引
		startIndex = (pagenum-1)*pagesize;
		//计算总页数
		totalpage = this.totalrecords%pagesize==0?this.totalrecords/pagesize:(this.totalrecords/pagesize+1);
		
		//显示的页码
		if(totalpage<=9){
			startPage = 1;
			endPage = totalpage;
		}else{
			startPage = pagenum-4;
			endPage = pagenum+4;
			if(startPage<1){
				startPage = 1;
				endPage = 9;
			}
			if(endPage>totalpage){
				endPage = totalpage;
				startPage = totalpage-8;
			}
		}
		if(totalrecords!=null)
			this.records=totalrecords.subList(startIndex,startIndex+pagesize>=this.totalrecords?this.totalrecords:startIndex+pagesize);
	}
	public Page(int pagenum, int totalrecords){
		this.pagenum = pagenum;
		this.totalrecords = totalrecords;
		
		//计算每页开始记录的索引
		startIndex = (pagenum-1)*pagesize;
		//计算总页数
		totalpage = totalrecords%pagesize==0?totalrecords/pagesize:(totalrecords/pagesize+1);
		
		//显示的页码
		if(totalpage<=9){
			startPage = 1;
			endPage = totalpage;
		}else{
			startPage = pagenum-4;
			endPage = pagenum+4;
			if(startPage<1){
				startPage = 1;
				endPage = 9;
			}
			if(endPage>totalpage){
				endPage = totalpage;
				startPage = totalpage-8;
			}
		}
	}
	public Page(int pagenum, int pagesize, int totalrecords){
		this.pagenum = pagenum;
		this.pagesize = pagesize;
		this.totalrecords = totalrecords;
		
		//计算每页开始记录的索引
		startIndex = (pagenum-1)*pagesize;
		//计算总页数
		totalpage = totalrecords%pagesize==0?totalrecords/pagesize:(totalrecords/pagesize+1);
		
		//显示的页码
		if(totalpage<=9){
			startPage = 1;
			endPage = totalpage;
		}else{
			startPage = pagenum-4;
			endPage = pagenum+4;
			if(startPage<1){
				startPage = 1;
				endPage = 9;
			}
			if(endPage>totalpage){
				endPage = totalpage;
				startPage = totalpage-8;
			}
		}
	}
	
	
	public List<T>  getRecords() {
		return records;
	}
	public void setRecords(List<T>  records) {
		this.records = records;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalrecords() {
		return totalrecords;
	}
	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
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


	public String getServletUrl() {
		return servletUrl;
	}


	public void setServletUrl(String servletUrl) {
		this.servletUrl = servletUrl;
	}


	@Override
	public String toString() {
		return "Page [records=" + records + ", pagesize=" + pagesize
				+ ", pagenum=" + pagenum + ", totalpage=" + totalpage
				+ ", startIndex=" + startIndex + ", totalrecords="
				+ totalrecords + ", startPage=" + startPage + ", endPage="
				+ endPage + ", servletUrl=" + servletUrl + "]";
	}
	
	
}