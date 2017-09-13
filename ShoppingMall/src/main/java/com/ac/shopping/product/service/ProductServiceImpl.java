package com.ac.shopping.product.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ac.shopping.product.dao.ProductDAOImpl;
import com.ac.shopping.product.dto.Outer_OnepieceDTO;
import com.ac.shopping.product.dto.ShoesDTO;
import com.ac.shopping.product.dto.TBADTO;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductDAOImpl productDao;

	public List<ShoesDTO> listShoes() {
		return productDao.listShoes();
	}
	
	public List<TBADTO> listTba() {
		return productDao.listTba();
	}

	@Override
	public List<TBADTO> topListProduct(int start, int end, String search_option, String search_keyword, String var) {
		int idf = 1;
		if(var.equals("tshirt")) {
			idf = 2;
		} else if(var.equals("mtmh")) {
			idf = 3;
		} else if(var.equals("blouse")) {
			idf = 4;
		} else if(var.equals("knit")) {
			idf = 5;
		}
		
		return productDao.topListProduct(start,end,search_option,search_keyword,idf);
	}

	@Override
	public List<TBADTO> bottomListProduct(String var) {
		int idf = 1;
		if(var.equals("spants")) {
			idf = 2;
		} else if(var.equals("lpants")) {
			idf = 3;
		} else if(var.equals("training")) {
			idf = 4;
		}
				
		return productDao.bottomListProduct(idf);
	}

	@Override
	public List<TBADTO> accListProduct(String var) {
		int idf = 1;
		if(var.equals("earings")) {
			idf = 2;
		} else if(var.equals("necklaces")) {
			idf = 3;
		} else if(var.equals("bracelets")) {
			idf = 4;
		} else if(var.equals("socks")) {
			idf = 5;
		} else if(var.equals("belts")) {
			idf = 6;
		}
		return productDao.accListProduct(idf);
	}

	@Override
	public List<Outer_OnepieceDTO> onepieceListProduct() {
		return productDao.onepieceListProduct();
	}

	@Override
	public List<Outer_OnepieceDTO> outerListProduct() {
		return productDao.outerListProduct();
	}

	public int all_count_tba(String search_option, String search_keyword, String var) {
		// TODO Auto-generated method stub
		return productDao.all_count_tba();
	}

	public HashMap detailshoes(String pro_no) {
		return productDao.detailshoes(pro_no);
	}

	public HashMap topDetail(String pro_no) {
		return productDao.topDetail(pro_no);
	}

	public HashMap bottomDetail(String pro_no) {
		return productDao.bottomDetail(pro_no);
	}

	public HashMap accDetail(String pro_no) {
		return productDao.accDetail(pro_no);
	}
}
