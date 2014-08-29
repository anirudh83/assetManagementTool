package com.xebia.assetManagement.service;

import com.xebia.assetManagement.model.Asset;
import com.xebia.assetManagement.model.User;

import java.util.List;

/**
 * Created by anirudh on 25/08/14.
 */
public interface AssetService {
    List<Asset> getAllAssets();
    public List<Asset> getAllAssets(User user);
    Asset createAsset(Asset asset);
    Asset findById(Long id);
}
