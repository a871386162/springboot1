package com.newer.springboot.Service;

import com.newer.springboot.mapper.BookableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookableService {
    @Autowired
    private BookableMapper bookableMapper;

    /**
     * 根据科室ID查询今天的挂号人数
     * @param deid
     * @return
     */
    public int getToday(Integer deid){
        return bookableMapper.getToday(deid);
    }
    /**
     * 根据科室ID查询昨天的挂号人数
     * @param deid
     * @return
     */
    public int getYesterday(Integer deid){
        return bookableMapper.getYesterday(deid);
    }
    /**
     * 根据科室ID查询本周的挂号人数
     * @param deid
     * @return
     */
    public int getWeek(Integer deid){
        return bookableMapper.getWeek(deid);
    }
    /**
     * 根据科室ID查询本周的挂号人数
     * @param deid
     * @return
     */
    public int getMonth(Integer deid){
        return bookableMapper.getMonth(deid);
    }
    /**
     * 根据科室ID查询本周的挂号人数
     * @param deid
     * @return
     */
    public int getQuarter(Integer deid){
        return bookableMapper.getQuarter(deid);
    }
}
