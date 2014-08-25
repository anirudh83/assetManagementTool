package com.xebia.assetManagement.persistence;

import com.xebia.assetManagement.model.Asset;
import com.xebia.assetManagement.model.User;

import java.util.List;

/**
 * Created by anirudh on 22/08/14.
 */
public interface AssetPersistence extends GenericDAO<Asset, Long> {
    List<Asset> getAllAssets();
    List<Asset> getAllAssets(User user);
}
