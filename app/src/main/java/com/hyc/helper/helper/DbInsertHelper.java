package com.hyc.helper.helper;

import com.hyc.helper.bean.BigImageLoadRecordBean;
import com.hyc.helper.bean.CourseInfoBean;
import com.hyc.helper.bean.ExamInfoBean;
import com.hyc.helper.bean.GradeInfoBean;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;

public class DbInsertHelper {

  public static Observable<Boolean> insertCourseInfo(List<CourseInfoBean> courseInfoBeans) {
    return Observable.create(emitter -> {
      DaoHelper.getDefault()
          .getDaoSession()
          .getCourseInfoBeanDao()
          .insertInTx(courseInfoBeans);
      emitter.onNext(true);
      emitter.onComplete();
    });
  }

  public static Observable<Boolean> insertBigImageLoadRecord(BigImageLoadRecordBean bean) {
    return Observable.create(emitter -> {
      DaoHelper.getDefault()
          .getDaoSession()
          .getBigImageLoadRecordBeanDao()
          .insertOrReplace(bean);
      emitter.onNext(true);
      emitter.onComplete();
    });
  }

  public static Observable<Boolean> insertExamInfo(List<ExamInfoBean> examInfoBeans){
    return Observable.create(emitter -> {
      DaoHelper.getDefault()
          .getDaoSession()
          .getExamInfoBeanDao()
          .insertInTx(examInfoBeans);
      emitter.onNext(true);
      emitter.onComplete();
    });
  }

  public static Observable<Boolean> insertGradeInfo(List<GradeInfoBean> gradeInfoBeans){
    return Observable.create(emitter -> {
      DaoHelper.getDefault()
          .getDaoSession()
          .getGradeInfoBeanDao()
          .insertInTx(gradeInfoBeans);
      emitter.onNext(true);
      emitter.onComplete();
    });
  }
}
