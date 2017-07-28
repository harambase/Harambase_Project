package com.youedata.cd.common.page;

import com.youedata.cd.basetwo.common.page.Page;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/4/1.
 */
public class DataModel extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private Integer draw;
    private Integer recordsTotal; // 数据库里总共记录数
    private Integer recordsFiltered; // 过滤后的记录数,如果有接收到前台的过滤条件，则返回的是过滤后的记录数
    private String error; // 可选。你可以定义一个错误来描述服务器出了问题后的友好提示
    private Object data;
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
        super.put("page", page);
    }

    public void setCode(int code) {
        this.code = code;
        super.put("code", code);
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
        super.put("recordsTotal", recordsTotal);
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
        super.put("recordsFiltered", recordsFiltered);
    }

    public void setError(String error) {
        this.error = error;
        super.put("error", error);
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
        super.put("draw", draw);
    }

    public void setMsg(String msg) {
        this.msg = msg;
        super.put("message", msg);
    }

    public void setData(Object data) {
        this.data = data;
        super.put("data", data);
    }
}

