package com.hyc.helper.helper;

import com.hyc.helper.bean.BigImageLoadRecordBean;
import com.hyc.helper.bean.CourseBean;
import com.hyc.helper.bean.CourseInfoBean;
import com.hyc.helper.bean.ExamBean;
import com.hyc.helper.bean.ExamInfoBean;
import com.hyc.helper.bean.GradeBean;
import com.hyc.helper.bean.GradeInfoBean;
import com.hyc.helper.gen.BigImageLoadRecordBeanDao;
import com.hyc.helper.gen.CourseInfoBeanDao;
import com.hyc.helper.gen.ExamInfoBeanDao;
import io.reactivex.Observable;
import java.util.List;

public class DbSearchHelper {

  public static Observable<CourseBean> searchCourseInfo(String studentId) {
    return Observable.create(emitter -> {
      List<CourseInfoBean> courseInfoBeans = DaoHelper.getDefault()
          .getDaoSession()
          .getCourseInfoBeanDao()
          .queryBuilder()
          .where(CourseInfoBeanDao.Properties.Xh.eq(studentId))
          .build().list();
      CourseBean courseBean = new CourseBean();
      if (courseInfoBeans != null && courseInfoBeans.size() > 0) {
        courseBean.setCode(Constant.REQUEST_SUCCESS);
      } else {
        courseBean.setCode(Constant.NEED_API_DATA);
      }
      courseBean.setData(courseInfoBeans);
      emitter.onNext(courseBean);
      emitter.onComplete();
    });
  }

  public static Observable<BigImageLoadRecordBean> searchBigImageLoadRecord(String originUrl){
    return Observable.create(emitter -> {
      BigImageLoadRecordBean bean = DaoHelper.getDefault()
          .getDaoSession()
          .getBigImageLoadRecordBeanDao()
          .queryBuilder()
          .where(BigImageLoadRecordBeanDao.Properties.OriginUrl.eq(originUrl))
          .build().unique();
      emitter.onNext(bean);
      emitter.onComplete();
    });
  }

  public static Observable<ExamBean> searchExamInfo(){
    return Observable.create(emitter -> {
      List<ExamInfoBean> examInfoBeans = DaoHelper.getDefault()
          .getDaoSession()
          .getExamInfoBeanDao()
          .queryBuilder()
          .list();
      ExamBean examBean = new ExamBean();
      if (examInfoBeans.size()>0){
        examBean.setStatus("success");
      }else {
        examBean.setStatus("need_api");
      }
      ExamBean.ResBean resBean =new ExamBean.ResBean();
      resBean.setExam(examInfoBeans);
      examBean.setRes(resBean);
      emitter.onNext(examBean);
      emitter.onComplete();
    });
  }

  public static Observable<GradeBean> searchGradeInfo(){
    return Observable.create(emitter -> {
      List<GradeInfoBean> gradeInfoBeans = DaoHelper.getDefault()
          .getDaoSession()
          .getGradeInfoBeanDao()
          .queryBuilder()
          .list();
      GradeBean gradeBean = new GradeBean();
      if (gradeInfoBeans.size()>0){
        gradeBean.setCode(Constant.REQUEST_SUCCESS);
      }else {
        gradeBean.setCode(Constant.NEED_API_DATA);
      }
      gradeBean.setData(gradeInfoBeans);
      emitter.onNext(gradeBean);
      emitter.onComplete();
    });
  }

}
