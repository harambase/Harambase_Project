package com.youedata.cd.common.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
public enum Zz {

    ZzGaJdcjsz("1", "市公安局", "zz_ga","机动车驾驶证", "zz_ga_jdcjsz" , "../queryZzData/zzGaJdcjszDetail.do", "1", "zh"),
    ZzGaBjtxxk("2", "市公安局", "zz_ga", "大陆居民在大陆边境管理区通行许可", "zz_ga_bjtxxk`", "", "1", "sfzhm"),
    ZzGaSfz("3", "市公安局", "zz_ga", "身份证", "zz_ga_sfz", "../queryZzData/zzGaSfzDetail.do", "1", "sfzh"),
    ZzGsYyzz("4", "市工商局","zz_gs", "营业执照", "zz_gs_yyzz", "../queryZzData/zzGsYyzzDetail.do", "2", "fddbr"),
    ZzMzShttfrdjz("5", "市民政局", "zz_mz","社会团体法人登记证书","zz_mz_shttfrdjz" ,"../queryZzData/zzMzShttfrdjzDetail.do", "2", "fddbr"),
    ZzMzMbfqy("6", "市民政局", "zz_mz", "民办非企业登记证书", "zz_mz_mbfqy","../queryZzData/zzMzMbfqyDetail.do", "2", "fddbr");

    /**
     * 证件所属部委
     */
    private String ministry;

    /**
     * 部委拼音缩写
     */
    private String ministrySpell;

    /**
     * 证件名称
     */
    private String zzName;

    /**
     * 证照拼音缩写
     */
    private String zzSpell;
    /**
     * 进入证件详情地址
     */
    private String detailUrl;

    /**
     * 查询组
     */
    private String queryGroup;

    /**
     * 查询关键字key
     */

    private String queryKey;

    /**
     * 查询关键字value
     */
    private String queryField;


    private Zz( String queryKey, String ministry, String ministrySpell, String zzName,String zzSpell, String detailUrl, String queryGroup, String queryField){
        this.queryKey = queryKey;
        this.ministry = ministry;
        this.ministrySpell = ministrySpell;
        this.zzName = zzName;
        this.zzSpell = zzSpell;
        this.detailUrl = detailUrl;
        this.queryGroup = queryGroup;
        this.queryField = queryField;
    }

    public String getMinistry() {
        return ministry;
    }

    public void setMinistry(String ministry) {
        this.ministry = ministry;
    }

    public String getMinistrySpell() {
        return ministrySpell;
    }

    public void setMinistrySpell(String ministrySpell) {
        this.ministrySpell = ministrySpell;
    }

    public String getZzName() {
        return zzName;
    }

    public void setZzName(String zzName) {
        this.zzName = zzName;
    }

    public String getZzSpell() {
        return zzSpell;
    }

    public void setZzSpell(String zzSpell) {
        this.zzSpell = zzSpell;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getQueryKey() {
        return queryKey;
    }

    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey;
    }

    public String getQueryGroup() {
        return queryGroup;
    }

    public void setQueryGroup(String queryGroup) {
        this.queryGroup = queryGroup;
    }

    public String getQueryField() {
        return queryField;
    }

    public void setQueryField(String queryField) {
        this.queryField = queryField;
    }

    public static String getQueryGroup(String queryKey) {
        for (Zz c : Zz.values()) {
            if (c.getQueryKey().equals(queryKey)) {
                return c.getQueryGroup();
            }
        }
        return null;
    }

    public static String getQueryZzName(String queryKey) {
        for (Zz c : Zz.values()) {
            if (c.getQueryKey().equals(queryKey)) {
                return c.getZzName();
            }
        }
        return null;
    }

    public static String getQueryField(String queryKey) {
        for (Zz c : Zz.values()) {
            if (c.getQueryKey().equals(queryKey)) {
                return c.getQueryField();
            }
        }
        return null;
    }

    public static Zz getZzObjByzzmc(String zzmc) {
        for (Zz c : Zz.values()) {
            if (c.getZzName().equals(zzmc)) {
                return c;
            }
        }
        return null;
    }

    public static Zz getZzObjByMinistry(String ministry) {
        for (Zz c : Zz.values()) {
            if (c.getMinistry().equals(ministry)) {
                return c;
            }
        }
        return null;
    }
    public static List<Zz> getAllZzObjByMinistry(String ministry) {
        List<Zz> zzList = new ArrayList<>();
        for (Zz c : Zz.values()) {
            if (c.getMinistry().equals(ministry)) {
                zzList.add(c);
            }
        }
        return zzList;
    }
}
