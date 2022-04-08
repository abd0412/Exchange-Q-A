package cn.edu.guet.exchange.entities;

import lombok.Data;

import java.util.Date;

/**
 * @Author:     cyan
 * @Description:  ${description}  
 * @Date:    2021/11/8 20:27
 * @Version:    1.0
 */

/**
 * 这是用户表，用来记录关于用户的各维度属性
 */
@Data
public class User {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户登录账号，唯一，系统分配
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别，0未知，1男，2女
     */
    private Integer sex;

    /**
     * 一句话介绍
     */
    private String introduce;

    /**
     * 居住地
     */
    private String address;

    /**
     * 所在行业
     */
    private String industry;

    /**
     * 职业经历
     */
    private String profession;

    /**
     * 教育经历
     */
    private String education;

    /**
     * 个人认证
     */
    private String authentication;

    /**
     * 个人简介
     */
    private String briefIntroduction;

    /**
     * 头像
     */
    private String headLogo;

    /**
     * 关注者数量
     */
    private Integer followerNumber;

    /**
     * 备注
     */
    private String mark;

    /**
     * 用户注册的时间
     */
    private String createTime;

    /**
     * 用户最后一次修改的时间
     */
    private String updateTime;

    /**
     * 逻辑注销，0不生效，1生效
     */
    private Boolean isDelete;
}