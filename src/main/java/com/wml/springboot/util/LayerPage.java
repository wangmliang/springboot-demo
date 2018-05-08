package com.wml.springboot.util;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * layerUi框架分页
 * <pre>
 * <b>Title：</b>LayerPage.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018年1月20日 - 上午11:08:18<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class LayerPage<T> {

    /** 代码，默认0 **/
    private Integer code;

    /** 提示 **/
    private String msg;

    /** 总条数 **/
    private Long count;

    /** 分页数据 **/
    private List<T> data;

    /**
     *
     * @Description:  分页结果构造
     * @author:qmh
     * @date 2017年12月5日 下午5:20:41
     * @param pageInfo
     */
    public LayerPage(PageInfo<T> pageInfo) {
        this.code = 0;
        this.msg = "";
        if (pageInfo != null) {
            this.count = pageInfo.getTotal();
            this.data = pageInfo.getList();
        }else {
            this.count = 0L;
            this.data = null;
        }
    }

    /** 代码，默认0 **/
    public Integer getCode() {
        return code;
    }

    /** 代码，默认0 **/
    public void setCode(Integer code) {
        this.code = code;
    }

    /** 提示 **/
    public String getMsg() {
        return msg;
    }

    /** 提示 **/
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /** 总条数 **/
    public Long getCount() {
        return count;
    }

    /** 总条数 **/
    public void setCount(Long count) {
        this.count = count;
    }

    /** 分页数据 **/
    public List<T> getData() {
        return data;
    }

    /** 分页数据 **/
    public void setData(List<T> data) {
        this.data = data;
    }

}
