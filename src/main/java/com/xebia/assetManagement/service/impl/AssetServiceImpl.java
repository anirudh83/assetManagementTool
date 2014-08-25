package com.xebia.assetManagement.service.impl;

import com.xebia.assetManagement.model.Asset;
import com.xebia.assetManagement.persistence.AssetPersistence;
import com.xebia.assetManagement.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by anirudh on 25/08/14.
 */
@Service
@Transactional
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetPersistence assetPersistence;

    @Override
    public List<Asset> getAllAssets() {
        return assetPersistence.getAllAssets();
    }

    @Override
    public List<Asset> getAllAssets(String username) {
        return assetPersistence.getAllAssets(username);
    }

    @Override
    public Asset createAsset(Asset asset) {
        return assetPersistence.makePersistant(asset);
    }
}
