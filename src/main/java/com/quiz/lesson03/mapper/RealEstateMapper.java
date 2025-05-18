package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	 // input: id
	 // output: RealEstate(단건) or null
	public RealEstate selectRealEstateById(int id);
	
	
	 // input: rentPrice(int)
	 // output: List<RealEstate>
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	
	 // input: area, price
	 // output: List<RealEstate>
	public List<RealEstate> selectRealEstateListByAreaPrice(
			 // xml로 파라미터를 보낼 때 한개 밖에 못보낸다.
			 // 파라미터들을 하나의 Map으로 담아 보낸다.
			 // @Param 어노테이션을 붙이면 하나의 Map이 된다.
			@Param("area") int area,
			@Param("price") int price);
	
	 // input: RealEstate
	 // output: int(성공한 행 개수)
	public int insertRealEstate(RealEstate realEstate);
	
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId, 
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") Integer rentPrice);
	
	public int updateRealEstateById(
			@Param("id") int id, 
			@Param("type") String type,
			@Param("price") int price);
	
	
	public int deleteRealEstateById(int id);
}
