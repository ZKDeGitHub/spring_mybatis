package com.edu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author zk
 * @Date 2023/7/6 10:13
 * @注释：
 * @since 11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String userName;
    private LocalDate birthday;
    private String gender;
    private String address;
}
