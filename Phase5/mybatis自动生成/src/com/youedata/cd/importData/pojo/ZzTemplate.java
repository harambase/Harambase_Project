package com.youedata.cd.importData.pojo;

public class ZzTemplate {
    private Integer id;

    private String zzlx;

    private String attrName;

    private String desc;

    private String fontFamily;

    private String fontStyle;

    private String color;

    private Integer fontSize;

    private Integer x;

    private Integer y;

    private Integer wordSpacing;

    private Integer lineHeight;

    private Integer wordWrap;

    private Integer textIndent;

    private String side;

    private Integer page;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZzlx() {
        return zzlx;
    }

    public void setZzlx(String zzlx) {
        this.zzlx = zzlx == null ? null : zzlx.trim();
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily == null ? null : fontFamily.trim();
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle == null ? null : fontStyle.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getWordSpacing() {
        return wordSpacing;
    }

    public void setWordSpacing(Integer wordSpacing) {
        this.wordSpacing = wordSpacing;
    }

    public Integer getLineHeight() {
        return lineHeight;
    }

    public void setLineHeight(Integer lineHeight) {
        this.lineHeight = lineHeight;
    }

    public Integer getWordWrap() {
        return wordWrap;
    }

    public void setWordWrap(Integer wordWrap) {
        this.wordWrap = wordWrap;
    }

    public Integer getTextIndent() {
        return textIndent;
    }

    public void setTextIndent(Integer textIndent) {
        this.textIndent = textIndent;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side == null ? null : side.trim();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}