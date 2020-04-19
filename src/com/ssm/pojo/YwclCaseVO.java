package com.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 陈宜康
 * @date 2019/8/2 19:22
 * @forWhat
 */
public class YwclCaseVO implements Serializable {
    //	日期	
    private Date rq;
    //	来电总量
    private String ldzl;
    //	转接人工量
    private String zjrgl;
    //	人工接听量
    private String rgjtl;
    //	20秒人工接听量
    private String rgjtl20;
    //	30秒人工接听量
    private String rgjtl30;
    //	60秒人工接听量
    private String rgjtl60;
    //	直接挂断量
    private String zjgdl;
    //	直接说转人工量
    private String zjzrgl;
    //	有问答复后挂断量
    private String ywdfgdl;
    //	有问答复后转人工量
    private String ywdfzrgl;
    //	有问未答复挂断量
    private String ywwdfgdl;
    //	有问未答复转人工量
    private String ywwdfzrgl;
    //	未提问挂断量
    private String wwgdl;
    //	未提问转人工量
    private String wwzrgl;
    //	有效提问总量
    private String yxtwzl;
    //	无效提问总量
    private String wxtwzl;
    //	多次提问量
    private String dctwl;
    //	答复总数
    private String dfzs;
    //	智能导航来电总量
    private String zndhldzl;

    public Date getRq() {
        return rq;
    }

    public void setRq(Date rq) {
        this.rq = rq;
    }

    public String getLdzl() {
        return ldzl;
    }

    public void setLdzl(String ldzl) {
        this.ldzl = ldzl;
    }

    public String getZjrgl() {
        return zjrgl;
    }

    public void setZjrgl(String zjrgl) {
        this.zjrgl = zjrgl;
    }

    public String getRgjtl() {
        return rgjtl;
    }

    public void setRgjtl(String rgjtl) {
        this.rgjtl = rgjtl;
    }

    public String getRgjtl20() {
        return rgjtl20;
    }

    public void setRgjtl20(String rgjtl20) {
        this.rgjtl20 = rgjtl20;
    }

    public String getRgjtl30() {
        return rgjtl30;
    }

    public void setRgjtl30(String rgjtl30) {
        this.rgjtl30 = rgjtl30;
    }

    public String getRgjtl60() {
        return rgjtl60;
    }

    public void setRgjtl60(String rgjtl60) {
        this.rgjtl60 = rgjtl60;
    }

    public String getZjgdl() {
        return zjgdl;
    }

    public void setZjgdl(String zjgdl) {
        this.zjgdl = zjgdl;
    }

    public String getZjzrgl() {
        return zjzrgl;
    }

    public void setZjzrgl(String zjzrgl) {
        this.zjzrgl = zjzrgl;
    }

    public String getYwdfgdl() {
        return ywdfgdl;
    }

    public void setYwdfgdl(String ywdfgdl) {
        this.ywdfgdl = ywdfgdl;
    }

    public String getYwdfzrgl() {
        return ywdfzrgl;
    }

    public void setYwdfzrgl(String ywdfzrgl) {
        this.ywdfzrgl = ywdfzrgl;
    }

    public String getYwwdfgdl() {
        return ywwdfgdl;
    }

    public void setYwwdfgdl(String ywwdfgdl) {
        this.ywwdfgdl = ywwdfgdl;
    }

    public String getYwwdfzrgl() {
        return ywwdfzrgl;
    }

    public void setYwwdfzrgl(String ywwdfzrgl) {
        this.ywwdfzrgl = ywwdfzrgl;
    }

    public String getWwgdl() {
        return wwgdl;
    }

    public void setWwgdl(String wwgdl) {
        this.wwgdl = wwgdl;
    }

    public String getWwzrgl() {
        return wwzrgl;
    }

    public void setWwzrgl(String wwzrgl) {
        this.wwzrgl = wwzrgl;
    }

    public String getYxtwzl() {
        return yxtwzl;
    }

    public void setYxtwzl(String yxtwzl) {
        this.yxtwzl = yxtwzl;
    }

    public String getWxtwzl() {
        return wxtwzl;
    }

    public void setWxtwzl(String wxtwzl) {
        this.wxtwzl = wxtwzl;
    }

    public String getDctwl() {
        return dctwl;
    }

    public void setDctwl(String dctwl) {
        this.dctwl = dctwl;
    }

    public String getDfzs() {
        return dfzs;
    }

    public void setDfzs(String dfzs) {
        this.dfzs = dfzs;
    }

    public String getZndhldzl() {
        return zndhldzl;
    }

    public void setZndhldzl(String zndhldzl) {
        this.zndhldzl = zndhldzl;
    }
}
