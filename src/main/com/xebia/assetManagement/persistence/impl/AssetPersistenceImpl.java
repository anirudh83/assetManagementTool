package com.xebia.assetManagement.persistence.impl;

import com.xebia.assetManagement.model.Asset;
import com.xebia.assetManagement.persistence.AssetPersistence;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by anirudh on 22/08/14.
 */
@Repository
public class AssetPersistenceImpl extends GenericDAOImpl<Asset, Long> implements AssetPersistence {

    @Override
    public List<Asset> getAllAssets() {
        return null;
    }

    @Override
    public List<Asset> getAllAssets(String username) {
        return null;
    }
}
