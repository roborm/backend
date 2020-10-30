package com.roborm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roborm.model.Asset;
import com.roborm.repository.AssetRepository;

@RestController
@RequestMapping("/api/asset")
public class AssetController {
	@Autowired
	private AssetRepository assetRepository;

	@GetMapping("/asset")
	public List<Asset> getAllAsset() {
		return assetRepository.findAll();
	}

}
