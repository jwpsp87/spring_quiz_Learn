package com.quiz.lesson03.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper;
	
	 // input: id
	 // output: RealEstate(단건) or null
	public RealEstate getRealEstateById(int id) {
		
		return realEstateMapper.selectRealEstateById(id);
		
	}
	
	public 	List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
	
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price) {
//		Map<String, Object> params = new HashMap<>();
//		params.put("area", area);
//		params.put("price", price);
		return realEstateMapper.selectRealEstateListByAreaPrice(area, price);
	}
	
	public int addRealEstate(RealEstate realEstate) {
		
		return realEstateMapper.insertRealEstate(realEstate);
		
	}
	
//	addRealEstateAsField(realtorId, "쌍떼빌리버 오피스텔 814호",
//			  45, "월세", 100000, 120)
	public int addRealEstateAsField(int realtorId, String address, int area,
									String type, int price, Integer rentPrice) {
		
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
		
	}
	
	public int updateRealEstateById (
			int id,
			String type,
			int price) {
		
		return realEstateMapper.updateRealEstateById(id, type, price);
		
	}
	
	public int deleteRealEstateById(int id) {
		
		return realEstateMapper.deleteRealEstateById(id);
		
	}
	
}
