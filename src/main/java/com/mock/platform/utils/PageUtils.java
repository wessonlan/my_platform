package com.mock.platform.utils;

import org.springframework.data.domain.Page;

public class PageUtils<T> {
    Page<T> pageFromJPA;

    int totalPages;
    int number;
    int size;
}
