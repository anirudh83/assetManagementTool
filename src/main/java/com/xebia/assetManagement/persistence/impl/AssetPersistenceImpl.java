package com.xebia.assetManagement.persistence.impl;

import com.xebia.assetManagement.model.Asset;
import com.xebia.assetManagement.model.User;
import com.xebia.assetManagement.persistence.AssetPersistence;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by anirudh on 22/08/14.
 */
@Repository
public class AssetPersistenceImpl extends GenericDAOImpl<Asset, Long> implements AssetPersistence {

    @Override
    public List<Asset> getAllAssets() {
        return findAll();
    }

    @Override
    public List<Asset> getAllAssets(User user) {
        Session sess = getSession();
        Query query = sess.createQuery(
                "from Asset as asset where asset.assignedTo.id = ?")
                .setString(0, user.getId().toString());

        return query.list();
    }
}
