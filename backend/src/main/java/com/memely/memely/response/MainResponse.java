package com.memely.memely.response;

import java.util.List;

import com.memely.memely.dto.UserDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainResponse<T> {
    private List<T> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}