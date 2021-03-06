package com.hyc.helper.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.hyc.helper.bean.ExamInfoBean;
import com.hyc.helper.bean.GradeInfoBean;
import com.hyc.helper.bean.CourseInfoBean;
import com.hyc.helper.bean.BigImageLoadRecordBean;

import com.hyc.helper.gen.ExamInfoBeanDao;
import com.hyc.helper.gen.GradeInfoBeanDao;
import com.hyc.helper.gen.CourseInfoBeanDao;
import com.hyc.helper.gen.BigImageLoadRecordBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig examInfoBeanDaoConfig;
    private final DaoConfig gradeInfoBeanDaoConfig;
    private final DaoConfig courseInfoBeanDaoConfig;
    private final DaoConfig bigImageLoadRecordBeanDaoConfig;

    private final ExamInfoBeanDao examInfoBeanDao;
    private final GradeInfoBeanDao gradeInfoBeanDao;
    private final CourseInfoBeanDao courseInfoBeanDao;
    private final BigImageLoadRecordBeanDao bigImageLoadRecordBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        examInfoBeanDaoConfig = daoConfigMap.get(ExamInfoBeanDao.class).clone();
        examInfoBeanDaoConfig.initIdentityScope(type);

        gradeInfoBeanDaoConfig = daoConfigMap.get(GradeInfoBeanDao.class).clone();
        gradeInfoBeanDaoConfig.initIdentityScope(type);

        courseInfoBeanDaoConfig = daoConfigMap.get(CourseInfoBeanDao.class).clone();
        courseInfoBeanDaoConfig.initIdentityScope(type);

        bigImageLoadRecordBeanDaoConfig = daoConfigMap.get(BigImageLoadRecordBeanDao.class).clone();
        bigImageLoadRecordBeanDaoConfig.initIdentityScope(type);

        examInfoBeanDao = new ExamInfoBeanDao(examInfoBeanDaoConfig, this);
        gradeInfoBeanDao = new GradeInfoBeanDao(gradeInfoBeanDaoConfig, this);
        courseInfoBeanDao = new CourseInfoBeanDao(courseInfoBeanDaoConfig, this);
        bigImageLoadRecordBeanDao = new BigImageLoadRecordBeanDao(bigImageLoadRecordBeanDaoConfig, this);

        registerDao(ExamInfoBean.class, examInfoBeanDao);
        registerDao(GradeInfoBean.class, gradeInfoBeanDao);
        registerDao(CourseInfoBean.class, courseInfoBeanDao);
        registerDao(BigImageLoadRecordBean.class, bigImageLoadRecordBeanDao);
    }
    
    public void clear() {
        examInfoBeanDaoConfig.clearIdentityScope();
        gradeInfoBeanDaoConfig.clearIdentityScope();
        courseInfoBeanDaoConfig.clearIdentityScope();
        bigImageLoadRecordBeanDaoConfig.clearIdentityScope();
    }

    public ExamInfoBeanDao getExamInfoBeanDao() {
        return examInfoBeanDao;
    }

    public GradeInfoBeanDao getGradeInfoBeanDao() {
        return gradeInfoBeanDao;
    }

    public CourseInfoBeanDao getCourseInfoBeanDao() {
        return courseInfoBeanDao;
    }

    public BigImageLoadRecordBeanDao getBigImageLoadRecordBeanDao() {
        return bigImageLoadRecordBeanDao;
    }

}
