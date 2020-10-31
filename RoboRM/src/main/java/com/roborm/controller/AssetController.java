package com.roborm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.manager.AssetManager;
import com.roborm.model.Asset;
import com.roborm.repository.AssetRepository;

@RestController
@RequestMapping("/api/asset")
public class AssetController {
	@Autowired
	private AssetRepository assetRepository;

	@GetMapping("/assets")
	public List<Asset> getAllAsset() {
		return assetRepository.findAll();
	}

	@GetMapping("/useridassets")
	public ResponseEntity<List<Asset>> getAssetByUserId(@Valid @RequestBody Asset ass) {
		return ResponseEntity.ok().body(assetRepository.findByUserId(ass.getUserId()));
	}

	@PostMapping("/add")
	public Asset createAsset(@Valid @RequestBody Asset asset) {
		return assetRepository.save(asset);
	}

	@PutMapping("/update")
	public ResponseEntity<Asset> updateAsserUserIdById(@Valid @RequestBody Asset newAsset)
			throws ResourceNotFoundException {
		AssetManager asset = new AssetManager(assetRepository);
		return ResponseEntity.ok().body(asset.UpdateUserIdAmtById(newAsset.getAssetId(), newAsset));
	}

}
