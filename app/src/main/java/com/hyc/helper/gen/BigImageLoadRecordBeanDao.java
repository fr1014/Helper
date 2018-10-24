package com.hyc.helper.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.hyc.helper.bean.BigImageLoadRecordBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BIG_IMAGE_LOAD_RECORD_BEAN".
*/
public class BigImageLoadRecordBeanDao extends AbstractDao<BigImageLoadRecordBean, String> {

    public static final String TABLENAME = "BIG_IMAGE_LOAD_RECORD_BEAN";

    /**
     * Properties of entity BigImageLoadRecordBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property OriginUrl = new Property(0, String.class, "originUrl", true, "ORIGIN_URL");
        public final static Property FilePath = new Property(1, String.class, "filePath", false, "FILE_PATH");
    }


    public BigImageLoadRecordBeanDao(DaoConfig config) {
        super(config);
    }
    
    public BigImageLoadRecordBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BIG_IMAGE_LOAD_RECORD_BEAN\" (" + //
                "\"ORIGIN_URL\" TEXT PRIMARY KEY NOT NULL ," + // 0: originUrl
                "\"FILE_PATH\" TEXT);"); // 1: filePath
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BIG_IMAGE_LOAD_RECORD_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, BigImageLoadRecordBean entity) {
        stmt.clearBindings();
 
        String originUrl = entity.getOriginUrl();
        if (originUrl != null) {
            stmt.bindString(1, originUrl);
        }
 
        String filePath = entity.getFilePath();
        if (filePath != null) {
            stmt.bindString(2, filePath);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, BigImageLoadRecordBean entity) {
        stmt.clearBindings();
 
        String originUrl = entity.getOriginUrl();
        if (originUrl != null) {
            stmt.bindString(1, originUrl);
        }
 
        String filePath = entity.getFilePath();
        if (filePath != null) {
            stmt.bindString(2, filePath);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public BigImageLoadRecordBean readEntity(Cursor cursor, int offset) {
        BigImageLoadRecordBean entity = new BigImageLoadRecordBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // originUrl
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // filePath
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, BigImageLoadRecordBean entity, int offset) {
        entity.setOriginUrl(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setFilePath(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final String updateKeyAfterInsert(BigImageLoadRecordBean entity, long rowId) {
        return entity.getOriginUrl();
    }
    
    @Override
    public String getKey(BigImageLoadRecordBean entity) {
        if(entity != null) {
            return entity.getOriginUrl();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(BigImageLoadRecordBean entity) {
        return entity.getOriginUrl() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
