package cn.edu.guet.exchange.entities;

import lombok.Data;

import java.util.List;

/**
 * @Author: cyan
 * @Description:
 * @Date: 2021/11/16 22:42
 * @Version: 1.0
 */
@Data
public class ResponseList {
    private List<Response> responseList;

    private Integer totalPages;
}
