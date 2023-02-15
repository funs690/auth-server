package com.zjuici.authserver.service;

import com.google.common.collect.Lists;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName BaseService
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:47
 * @Version 1.0
 */
public interface BasicService<T, ID>{

    /**
     * 默认批量处理批次大小
     */
    int DEFAULT_BATCH_SIZE = 1000;


    /**
     * get jpa repostory
     * @return
     */
    JpaRepository<T, ID> getJapRepository();


    /**
     * @desc: 数据保存
     * @author: fuzeqiang
     * @date: 2023/2/7 17:49
     * @param record 数据记录
     * @return T
     **/
    default T save(T record){
        return getJapRepository().save(record);
    }

    /**
     * @desc: 数据更新
     * @author: fuzeqiang
     * @date: 2023/2/7 17:51
     * @param record 数据记录
     **/
    default void update(T record){
        getJapRepository().save(record);
    }

    /**
     * @desc: 数据删除
     * @author: fuzeqiang
     * @date: 2023/2/7 17:51
     * @param record 数据记录
     **/
    default void delete(T record){
        getJapRepository().delete(record);
    }

    /**
     * 数据批量处理
     * @param list 批量数据
     */
    default void batchSave(List<T> list){
        //数据存储
        List<List<T>> splits = Lists.partition(list, DEFAULT_BATCH_SIZE);
        splits.forEach(item -> getJapRepository().saveAll(item));
    }

    /**
     * @desc: 数据批量删除
     * @author: fuzeqiang
     * @date: 2023/2/7 18:01
     * @param list 批量数据
     **/
    default void batchDelete(List<T> list){
        //数据删除
        List<List<T>> splits = Lists.partition(list, DEFAULT_BATCH_SIZE);
        splits.forEach(item -> getJapRepository().deleteAll(item));
    }

    /**
     * @desc: 获取单个对象
     * @author: fuzeqiang
     * @date: 2023/2/7 18:49
     * @param id id值
     * @return T
     **/
    default T findById(ID id){
        return getJapRepository().findById(id).get();
    }

}
