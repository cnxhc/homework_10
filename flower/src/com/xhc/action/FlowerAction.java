package com.xhc.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xhc.model.Goods;
import com.xhc.service.ICatalogService;
import com.xhc.service.IFlowerService;
import com.xhc.util.Pager;
import com.xhc.util.uploadzp;

public class FlowerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ICatalogService catalogService;
	private IFlowerService flowerService;
	// 鲜花分类号
	private int catalogId;
	// 当前页码
	private int currentPage = 1;
	private Goods good;
	private String picture;
	private File upload;
	private String uploadFileName;
	// 鲜花的id
	private int id;
	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public IFlowerService getFlowerService() {
		return flowerService;
	}

	public void setFlowerService(IFlowerService flowerService) {
		this.flowerService = flowerService;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Goods getGood() {
		return good;
	}

	public void setGood(Goods good) {
		this.good = good;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	// 根据分类获取
	public String browseCatalog() {
		List catalogs = catalogService.getAllCatalogs();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("catalogs", catalogs);
		return "browseCatalog_success";
	}

	// 获取新入库的鲜花
	public String browseNewFlower() {
		List newgoods = flowerService.getNewFlower();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("newgoods", newgoods);
		return "browseNewFlower_success";
	}

	// 分页显示鲜花
	public String browseFlowerPaging() {
		int totalSize = flowerService.getTotalByCatalog(catalogId);
		Pager page = new Pager(currentPage, totalSize);
		List goods = flowerService.getFlowerByCatalogidPaging(catalogId, currentPage, page.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("goods", goods);
		request.put("page", page);
		return "browseFlowerPaging_success";
	}

	// 添加和修改鲜花
	public String addOrUpdateGoods() {
		String path = ServletActionContext.getServletContext().getRealPath("/image");
		System.out.println(path);
		List list = flowerService.getNewFlower();
		Goods good1 = (Goods) list.get(0);
		int currentGoodId = good1.getId() + 1;
		path = path + "\\" + currentGoodId + this.getUploadFileName();
		new uploadzp().upload(this.getUpload(), path);
		good.setImgUrl(currentGoodId + this.getUploadFileName());

		Goods good2 = new Goods();
		good2.setCatalog(good.getCatalog());
		good2.setGoodsName(good.getGoodsName());
		if (good.getImgUrl() == null) {
			good2.setImgUrl(picture);
		} else {
			good2.setImgUrl(good.getImgUrl());
		}
		good2.setPrice(good.getPrice());
		good2.setId(good.getId());
		if (flowerService.addOrUpdateGood(good2)) {
			return "addOrUpdateGoods_success";
		} else {
			return "addOrUpdateGoods_error";
		}
	}

	// 分页显示左右鲜花
	public String browseAllFlowerPaging() throws Exception {
		int totalSize = flowerService.getTotalNum();
		Pager page = new Pager(currentPage, totalSize);
		List goods = flowerService.getAllGoods(currentPage, page.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("goods", goods);
		request.put("page", page);
		return "browseAllFlowerPaging_success";
	}

	// 显示一朵鲜花，用于修改该鲜花
	public String displayOneFlower() {
		Goods modifyGoods = flowerService.getGoodsById(id);
		System.out.println(modifyGoods);
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("good", modifyGoods);
		return "displayOneFlower_success";
	}
	/*
	 * 删除鲜花
	 */
	public String deleteOneFlower()throws Exception
	{
		flowerService.deleteGoodsById(id);
		return "deleteOneFlower_success";
		
	}
}
