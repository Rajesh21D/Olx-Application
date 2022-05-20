package com.zensar.product.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.product.entity.CouponDto;

@FeignClient("COUPON-SERVICE")
public interface RestClient {
	
	@GetMapping("/coupons/coupon/{couponCode}")
	public CouponDto getByCouponCode(@PathVariable("couponCode")String couponCode);

}
