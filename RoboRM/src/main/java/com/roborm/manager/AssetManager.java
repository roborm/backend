package com.roborm.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.model.Asset;
import com.roborm.repository.AssetRepository;

@Service
public class AssetManager {
	private AssetRepository assetRepository;

	public AssetManager(AssetRepository assetRepository) {
		this.assetRepository = assetRepository;
	}

	public List<Asset> findAll() {
		return assetRepository.findAll();
	}

// Find by assetId	
	public Long findById(Long id) throws ResourceNotFoundException
	{
		Asset asset = assetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Asset ID not found for this id :: " + id));
		return asset.getAssetId();
	}

//find by userId
	public Long findByUserId(Long id) throws ResourceNotFoundException {
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset User Id not found for this id :: " + id));
		return asset.getUserId();
	}

//Update userId and Amt by AssetId	
	public Asset UpdateUserIdAmtById(Long assetId, Asset newAsset) throws ResourceNotFoundException {
		Asset asset = assetRepository.findById(assetId)
				.orElseThrow(() -> new ResourceNotFoundException("Asset User Id not found for this id :: " + assetId));
		asset.setUserId(newAsset.getUserId());
		asset.setAmt(newAsset.getAmt());

		final Asset updateAsset = assetRepository.save(asset);
		return updateAsset;
	}

}
