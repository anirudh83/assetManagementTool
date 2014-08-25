package com.xebia.assetManagement.service;

import com.xebia.assetManagement.model.Asset;

import java.util.List;

/**
 * Created by anirudh on 25/08/14.
 */
public interface AssetService {
    List<Asset> getAllAssets();
    List<Asset> getAllAssets(String username);
    Asset createAsset(Asset asset);
}
